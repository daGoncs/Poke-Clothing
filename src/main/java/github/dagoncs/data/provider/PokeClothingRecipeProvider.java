package github.dagoncs.data.provider;

import github.dagoncs.data.provider.builder.TailoringRecipeBuilder;
import github.dagoncs.init.BlockInit;
import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
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

        Object[][] clothData = {
                {"white", Items.WHITE_WOOL}, {"light_gray", Items.LIGHT_GRAY_WOOL},
                {"gray", Items.GRAY_WOOL}, {"black", Items.BLACK_WOOL},
                {"brown", Items.BROWN_WOOL}, {"red", Items.RED_WOOL},
                {"orange", Items.ORANGE_WOOL}, {"yellow", Items.YELLOW_WOOL},
                {"lime", Items.LIME_WOOL}, {"green", Items.GREEN_WOOL},
                {"cyan", Items.CYAN_WOOL}, {"light_blue", Items.LIGHT_BLUE_WOOL},
                {"blue", Items.BLUE_WOOL}, {"purple", Items.PURPLE_WOOL},
                {"magenta", Items.MAGENTA_WOOL}, {"pink", Items.PINK_WOOL}
        };

        for (Object[] data : clothData) {
            String color = (String) data[0];
            Item wool = (Item) data[1];
            Item cloth = ItemInit.CLOTHS.get(color);

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, cloth, 4)
                    .input(wool, 1).input(Items.STRING, 4)
                    .criterion(hasItem(wool), conditionsFromItem(wool))
                    .offerTo(exporter);
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockInit.TAILORING_STATION)
                .pattern("CC")
                .pattern("PP")
                .pattern("PP")
                .input('C', PokeClothingTagProvider.CLOTH)
                .input('P', ItemTags.PLANKS)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        Item whiteCloth = ItemInit.CLOTHS.get("white");
        Item lightGrayCloth = ItemInit.CLOTHS.get("light_gray");
        Item grayCloth = ItemInit.CLOTHS.get("gray");
        Item blackCloth = ItemInit.CLOTHS.get("black");
        Item brownCloth = ItemInit.CLOTHS.get("brown");
        Item redCloth = ItemInit.CLOTHS.get("red");
        Item orangeCloth = ItemInit.CLOTHS.get("orange");
        Item yellowCloth = ItemInit.CLOTHS.get("yellow");
        Item limeCloth = ItemInit.CLOTHS.get("lime");
        Item greenCloth = ItemInit.CLOTHS.get("green");
        Item cyanCloth = ItemInit.CLOTHS.get("cyan");
        Item lightBlueCloth = ItemInit.CLOTHS.get("light_blue");
        Item blueCloth = ItemInit.CLOTHS.get("blue");
        Item magentaCloth = ItemInit.CLOTHS.get("magenta");
        Item pinkCloth = ItemInit.CLOTHS.get("pink");

        // Armor Recipes
        // KANTO ASH SET
        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH.helmet())
                .input(redCloth, 2).input(whiteCloth, 2).input(greenCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH.chestplate())
                .input(cyanCloth, 2).input(whiteCloth, 1).input(blueCloth, 4).input(yellowCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH.leggings())
                .input(lightBlueCloth, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.KANTO_ASH.boots())
                .input(whiteCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // MISTY SET
        TailoringRecipeBuilder.create(ItemInit.MISTY.chestplate())
                .input(yellowCloth, 6).input(redCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MISTY.leggings())
                .input(cyanCloth, 5)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MISTY.boots())
                .input(redCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // BROCK SET
        TailoringRecipeBuilder.create(ItemInit.BROCK.chestplate())
                .input(greenCloth, 5).input(orangeCloth, 3)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BROCK.leggings())
                .input(brownCloth, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BROCK.boots())
                .input(blueCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // JESSIE SET
        TailoringRecipeBuilder.create(ItemInit.JESSIE.chestplate())
                .input(whiteCloth, 3).input(blackCloth, 2).input(redCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JESSIE.leggings())
                .input(whiteCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JESSIE.boots())
                .input(blackCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // JAMES SET
        TailoringRecipeBuilder.create(ItemInit.JAMES.chestplate())
                .input(whiteCloth, 5).input(blackCloth, 2).input(redCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JAMES.leggings())
                .input(whiteCloth, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.JAMES.boots())
                .input(blackCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // MAY SET
        TailoringRecipeBuilder.create(ItemInit.MAY.helmet())
                .input(redCloth, 4).input(whiteCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MAY.chestplate())
                .input(redCloth, 3).input(whiteCloth, 2).input(yellowCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MAY.leggings())
                .input(grayCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.MAY.boots())
                .input(redCloth, 2).input(whiteCloth, 1).input(yellowCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // EMERALD MAY SET
        TailoringRecipeBuilder.create(ItemInit.EMERALD_MAY.helmet())
                .input(limeCloth, 4).input(lightGrayCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_MAY.chestplate())
                .input(orangeCloth, 4).input(limeCloth, 1).input(lightGrayCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_MAY.leggings())
                .input(orangeCloth, 2).input(lightGrayCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_MAY.boots())
                .input(limeCloth, 2).input(orangeCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // DAWN SET
        TailoringRecipeBuilder.create(ItemInit.DAWN.helmet())
                .input(whiteCloth, 4).input(pinkCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN.chestplate())
                .input(grayCloth, 6).input(pinkCloth, 1).input(whiteCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN.leggings())
                .input(pinkCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.DAWN.boots())
                .input(pinkCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // PLATINUM DAWN SET
        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN.chestplate())
                .input(magentaCloth, 6).input(pinkCloth, 1).input(whiteCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN.leggings())
                .input(magentaCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.PLATINUM_DAWN.boots())
                .input(magentaCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // BRENDAN SET
        TailoringRecipeBuilder.create(ItemInit.BRENDAN.helmet())
                .input(redCloth, 1).input(blackCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN.chestplate())
                .input(redCloth, 4).input(yellowCloth, 2).input(blackCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN.leggings())
                .input(blackCloth, 6).input(yellowCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.BRENDAN.boots())
                .input(redCloth, 3).input(blackCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // EMERALD BRENDAN SET
        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN.helmet())
                .input(greenCloth, 2).input(limeCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN.chestplate())
                .input(redCloth, 6).input(blackCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN.leggings())
                .input(grayCloth, 5).input(lightGrayCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.EMERALD_BRENDAN.boots())
                .input(redCloth, 2).input(whiteCloth, 1).input(limeCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // RED SET
        TailoringRecipeBuilder.create(ItemInit.RED.helmet())
                .input(redCloth, 3).input(whiteCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED.chestplate())
                .input(redCloth, 4).input(whiteCloth, 2).input(blackCloth, 2)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED.leggings())
                .input(blueCloth, 7)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.RED.boots())
                .input(redCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        // TEAM ROCKET GRUNT SET
        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT.helmet())
                .input(blackCloth, 2).input(grayCloth, 3)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT.chestplate())
                .input(blackCloth, 2).input(grayCloth, 3).input(lightGrayCloth, 2).input(redCloth, 1)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT.leggings())
                .input(blackCloth, 2).input(grayCloth, 5)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);

        TailoringRecipeBuilder.create(ItemInit.TEAM_ROCKET_GRUNT.boots())
                .input(lightGrayCloth, 4)
                .criterion("has_cloth", conditionsFromTag(PokeClothingTagProvider.CLOTH))
                .offerTo(exporter);
    }
}