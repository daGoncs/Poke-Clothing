package github.dagoncs.data.provider;

import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PokeClothingRecipeProvider extends FabricRecipeProvider {
    public PokeClothingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.WHITE_CLOTH, 4)
                .input(Items.WHITE_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIGHT_GRAY_CLOTH, 4)
                .input(Items.LIGHT_GRAY_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.GRAY_CLOTH, 4)
                .input(Items.GRAY_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BLACK_CLOTH, 4)
                .input(Items.BLACK_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BROWN_CLOTH, 4)
                .input(Items.BROWN_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.RED_CLOTH, 4)
                .input(Items.RED_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.ORANGE_CLOTH, 4)
                .input(Items.ORANGE_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.YELLOW_CLOTH, 4)
                .input(Items.YELLOW_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIME_CLOTH, 4)
                .input(Items.LIME_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.GREEN_CLOTH, 4)
                .input(Items.GREEN_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.CYAN_CLOTH, 4)
                .input(Items.CYAN_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIGHT_BLUE_CLOTH, 4)
                .input(Items.LIGHT_BLUE_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BLUE_CLOTH, 4)
                .input(Items.BLUE_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.PURPLE_CLOTH, 4)
                .input(Items.PURPLE_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.MAGENTA_CLOTH, 4)
                .input(Items.MAGENTA_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.PINK_CLOTH, 4)
                .input(Items.PINK_WOOL, 1)
                .input(Items.STRING, 4)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.KANTO_ASH_HELMET)
                .input('R', ItemInit.RED_CLOTH)
                .input('W', ItemInit.WHITE_CLOTH)
                .input('G', ItemInit.GREEN_CLOTH)
                .pattern("WGW")
                .pattern("R R")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.KANTO_ASH_CHESTPLATE)
                .input('C', ItemInit.CYAN_CLOTH)
                .input('W', ItemInit.WHITE_CLOTH)
                .input('B', ItemInit.BLUE_CLOTH)
                .input('Y', ItemInit.YELLOW_CLOTH)
                .pattern("W W")
                .pattern("BCB")
                .pattern("BYB")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.KANTO_ASH_LEGGINGS)
                .input('L', ItemInit.LIGHT_BLUE_CLOTH)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.KANTO_ASH_BOOTS)
                .input('W', ItemInit.WHITE_CLOTH)
                .pattern("W W")
                .pattern("W W")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.MISTY_CHESTPLATE)
                .input('Y', ItemInit.YELLOW_CLOTH)
                .input('R', ItemInit.RED_CLOTH)
                .pattern("R R")
                .pattern("YYY")
                .pattern("YYY")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.MISTY_LEGGINGS)
                .input('C', ItemInit.CYAN_CLOTH)
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.MISTY_BOOTS)
                .input('R', ItemInit.RED_CLOTH)
                .pattern("R R")
                .pattern("R R")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.BROCK_CHESTPLATE)
                .input('G', ItemInit.GREEN_CLOTH)
                .input('O', ItemInit.ORANGE_CLOTH)
                .pattern("O O")
                .pattern("GOG")
                .pattern("GGG")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.BROCK_LEGGINGS)
                .input('B', ItemInit.BROWN_CLOTH)
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.BROCK_BOOTS)
                .input('B', ItemInit.BLUE_CLOTH)
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.TEAM_ROCKET_GRUNT_HELMET)
                .input('B', ItemInit.BLACK_CLOTH)
                .input('G', ItemInit.GRAY_CLOTH)
                .pattern("GGG")
                .pattern("B B")
                .pattern("   ")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.TEAM_ROCKET_GRUNT_CHESTPLATE)
                .input('B', ItemInit.BLACK_CLOTH)
                .input('G', ItemInit.GRAY_CLOTH)
                .input('L', ItemInit.LIGHT_GRAY_CLOTH)
                .input('R', ItemInit.RED_CLOTH)
                .pattern("B B")
                .pattern("GRG")
                .pattern("LGL")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.TEAM_ROCKET_GRUNT_LEGGINGS)
                .input('B', ItemInit.BLACK_CLOTH)
                .input('G', ItemInit.GRAY_CLOTH)
                .pattern("BGB")
                .pattern("G G")
                .pattern("G G")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ItemInit.TEAM_ROCKET_GRUNT_BOOTS)
                .input('L', ItemInit.LIGHT_GRAY_CLOTH)
                .pattern("   ")
                .pattern("L L")
                .pattern("L L")
                .criterion("cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
    }
}
