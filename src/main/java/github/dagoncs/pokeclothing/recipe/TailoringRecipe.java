package github.dagoncs.pokeclothing.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class TailoringRecipe implements Recipe<RecipeInput> {
    private final List<Ingredient> ingredients;
    private final ItemStack result;

    public TailoringRecipe(List<Ingredient> ingredients, ItemStack result) {
        this.ingredients = ingredients;
        this.result = result;
    }

    @Override
    public boolean matches(RecipeInput input, World world) {
        // Creates a list of copies so we don't mess up the actual inventory
        List<ItemStack> testInventory = new java.util.ArrayList<>();
        for (int i = 0; i < input.getSize(); i++) {
            if (!input.getStackInSlot(i).isEmpty()) {
                testInventory.add(input.getStackInSlot(i).copy());
            }
        }

        // Iterate through every required ingredient
        for (Ingredient requiredIngredient : this.ingredients) {
            boolean foundIngredient = false;

            // Looks for a match in our test inventory
            for (ItemStack testStack : testInventory) {
                // If it matches and we still have items left in this stack
                if (requiredIngredient.test(testStack) && testStack.getCount() > 0) {
                    foundIngredient = true;
                    testStack.decrement(1); // Virtually consumes 1 item
                    break; // Moves to the next required ingredient
                }
            }

            // If we went through the whole inventory and didn't find this specific ingredient
            if (!foundIngredient) {
                return false;
            }
        }

        // Strict Check
        // Forbids "extra" items (trash) in the slots, uncomment this:
        /*
        for (ItemStack stack : testInventory) {
            if (stack.getCount() > 0) return false; // Fail if leftover items exist
        }
        */

        return true;
    }

    @Override
    public ItemStack craft(RecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return this.result.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup lookup) {
        return this.result;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.addAll(this.ingredients);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TAILORING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TAILORING_TYPE;
    }

    // JSON Reader
    public static class Serializer implements RecipeSerializer<TailoringRecipe> {
        public static final MapCodec<TailoringRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(recipe -> recipe.ingredients),
                ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
        ).apply(instance, TailoringRecipe::new));

        public static final PacketCodec<RegistryByteBuf, TailoringRecipe> PACKET_CODEC = PacketCodec.ofStatic(
                Serializer::write, Serializer::read
        );

        private static TailoringRecipe read(RegistryByteBuf buf) {
            DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);
            ingredients.replaceAll(ignored -> Ingredient.PACKET_CODEC.decode(buf));
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
            return new TailoringRecipe(ingredients, result);
        }

        private static void write(RegistryByteBuf buf, TailoringRecipe recipe) {
            buf.writeInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.PACKET_CODEC.encode(buf, ingredient);
            }
            ItemStack.PACKET_CODEC.encode(buf, recipe.result);
        }

        @Override
        public MapCodec<TailoringRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, TailoringRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }
}