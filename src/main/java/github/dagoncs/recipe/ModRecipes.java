package github.dagoncs.recipe;

import github.dagoncs.PokeClothing;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    // 1. Define the Serializer
    public static final RecipeSerializer<TailoringRecipe> TAILORING_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER,
            Identifier.of(PokeClothing.MOD_ID, "tailoring"),
            new TailoringRecipe.Serializer()
    );

    // 2. Define the Recipe Type
    public static final RecipeType<TailoringRecipe> TAILORING_TYPE = Registry.register(
            Registries.RECIPE_TYPE,
            Identifier.of(PokeClothing.MOD_ID, "tailoring"),
            new RecipeType<TailoringRecipe>() {
                @Override
                public String toString() {
                    return "tailoring";
                }
            }
    );

    public static void registerRecipes() {
        PokeClothing.LOGGER.info("Registering Custom Recipes for " + PokeClothing.MOD_ID);
        // Just calling this method triggers the static variables above to load
    }
}