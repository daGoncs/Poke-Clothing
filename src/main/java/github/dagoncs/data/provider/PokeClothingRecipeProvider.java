package github.dagoncs.data.provider;

import github.dagoncs.data.provider.builder.TailoringRecipeBuilder;
import github.dagoncs.init.BlockInit;
import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class PokeClothingRecipeProvider extends FabricRecipeProvider {
    public PokeClothingRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.WHITE_CLOTH, 4)
                .input(Items.WHITE_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIGHT_GRAY_CLOTH, 4)
                .input(Items.LIGHT_GRAY_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.GRAY_CLOTH, 4)
                .input(Items.GRAY_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BLACK_CLOTH, 4)
                .input(Items.BLACK_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BROWN_CLOTH, 4)
                .input(Items.BROWN_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.RED_CLOTH, 4)
                .input(Items.RED_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.ORANGE_CLOTH, 4)
                .input(Items.ORANGE_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.YELLOW_CLOTH, 4)
                .input(Items.YELLOW_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIME_CLOTH, 4)
                .input(Items.LIME_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.GREEN_CLOTH, 4)
                .input(Items.GREEN_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.CYAN_CLOTH, 4)
                .input(Items.CYAN_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.LIGHT_BLUE_CLOTH, 4)
                .input(Items.LIGHT_BLUE_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.BLUE_CLOTH, 4)
                .input(Items.BLUE_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.PURPLE_CLOTH, 4)
                .input(Items.PURPLE_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.MAGENTA_CLOTH, 4)
                .input(Items.MAGENTA_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ItemInit.PINK_CLOTH, 4)
                .input(Items.PINK_WOOL, 1).input(Items.STRING, 4)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.TAILORING_STATION)
                .pattern("CC")
                .pattern("PP")
                .pattern("PP")
                .input('C', PokeClothingTagProvider.CLOTH)
                .input('P', ItemTags.PLANKS)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // KANTO ASH SET
        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH_HELMET)
                .input(ItemInit.RED_CLOTH, 2)
                .input(ItemInit.WHITE_CLOTH, 2)
                .input(ItemInit.GREEN_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH_CHESTPLATE)
                .input(ItemInit.CYAN_CLOTH, 2)
                .input(ItemInit.WHITE_CLOTH, 1)
                .input(ItemInit.BLUE_CLOTH, 4)
                .input(ItemInit.YELLOW_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH_LEGGINGS)
                .input(ItemInit.LIGHT_BLUE_CLOTH, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH_BOOTS)
                .input(ItemInit.WHITE_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // MISTY SET
        TailoringRecipeBuilder.create(ItemInit.MISTY_CHESTPLATE)
                .input(ItemInit.YELLOW_CLOTH, 6)
                .input(ItemInit.RED_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MISTY_LEGGINGS)
                .input(ItemInit.CYAN_CLOTH, 5)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MISTY_BOOTS)
                .input(ItemInit.RED_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // BROCK SET
        TailoringRecipeBuilder.create(ItemInit.BROCK_CHESTPLATE)
                .input(ItemInit.GREEN_CLOTH, 5)
                .input(ItemInit.ORANGE_CLOTH, 3)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BROCK_LEGGINGS)
                .input(ItemInit.BROWN_CLOTH, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BROCK_BOOTS)
                .input(ItemInit.BLUE_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // JESSIE SET
        TailoringRecipeBuilder.create(ItemInit.JESSIE_CHESTPLATE)
                .input(ItemInit.WHITE_CLOTH, 3)
                .input(ItemInit.BLACK_CLOTH, 2)
                .input(ItemInit.RED_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JESSIE_LEGGINGS)
                .input(ItemInit.WHITE_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JESSIE_BOOTS)
                .input(ItemInit.BLACK_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // JAMES SET
        TailoringRecipeBuilder.create(ItemInit.JAMES_CHESTPLATE)
                .input(ItemInit.WHITE_CLOTH, 5)
                .input(ItemInit.BLACK_CLOTH, 2)
                .input(ItemInit.RED_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JAMES_LEGGINGS)
                .input(ItemInit.WHITE_CLOTH, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JAMES_BOOTS)
                .input(ItemInit.BLACK_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // DAWN SET
        TailoringRecipeBuilder.create(ItemInit.DAWN_HELMET)
                .input(ItemInit.WHITE_CLOTH, 4)
                .input(ItemInit.PINK_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN_CHESTPLATE)
                .input(ItemInit.GRAY_CLOTH, 6)
                .input(ItemInit.PINK_CLOTH, 1)
                .input(ItemInit.WHITE_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN_LEGGINGS)
                .input(ItemInit.PINK_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN_BOOTS)
                .input(ItemInit.PINK_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // PLATINUM DAWN SET
        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN_CHESTPLATE)
                .input(ItemInit.MAGENTA_CLOTH, 6)
                .input(ItemInit.PINK_CLOTH, 1)
                .input(ItemInit.WHITE_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN_LEGGINGS)
                .input(ItemInit.MAGENTA_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN_BOOTS)
                .input(ItemInit.MAGENTA_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // BRENDAN SET
        TailoringRecipeBuilder.create(ItemInit.BRENDAN_HELMET)
                .input(ItemInit.RED_CLOTH, 1)
                .input(ItemInit.BLACK_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN_CHESTPLATE)
                .input(ItemInit.RED_CLOTH, 4)
                .input(ItemInit.YELLOW_CLOTH, 2)
                .input(ItemInit.BLACK_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN_LEGGINGS)
                .input(ItemInit.BLACK_CLOTH, 6)
                .input(ItemInit.YELLOW_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN_BOOTS)
                .input(ItemInit.RED_CLOTH, 3)
                .input(ItemInit.BLACK_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // EMERALD BRENDAN SET
        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN_HELMET)
                .input(ItemInit.GREEN_CLOTH, 2)
                .input(ItemInit.LIME_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN_CHESTPLATE)
                .input(ItemInit.RED_CLOTH, 6)
                .input(ItemInit.BLACK_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN_LEGGINGS)
                .input(ItemInit.GRAY_CLOTH, 5)
                .input(ItemInit.LIGHT_GRAY_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN_BOOTS)
                .input(ItemInit.RED_CLOTH, 2)
                .input(ItemInit.WHITE_CLOTH, 1)
                .input(ItemInit.LIME_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);


        // RED SET
        TailoringRecipeBuilder.create(ItemInit.RED_HELMET)
                .input(ItemInit.RED_CLOTH, 3)
                .input(ItemInit.WHITE_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED_CHESTPLATE)
                .input(ItemInit.RED_CLOTH, 4)
                .input(ItemInit.WHITE_CLOTH, 2)
                .input(ItemInit.BLACK_CLOTH, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED_LEGGINGS)
                .input(ItemInit.BLUE_CLOTH, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED_BOOTS)
                .input(ItemInit.RED_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // TEAM ROCKET GRUNT SET
        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT_HELMET)
                .input(ItemInit.BLACK_CLOTH, 2)
                .input(ItemInit.GRAY_CLOTH, 3)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT_CHESTPLATE)
                .input(ItemInit.BLACK_CLOTH, 2)
                .input(ItemInit.GRAY_CLOTH, 3)
                .input(ItemInit.LIGHT_GRAY_CLOTH, 2)
                .input(ItemInit.RED_CLOTH, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT_LEGGINGS)
                .input(ItemInit.BLACK_CLOTH, 2)
                .input(ItemInit.GRAY_CLOTH, 5)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT_BOOTS)
                .input(ItemInit.LIGHT_GRAY_CLOTH, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);


    }
}