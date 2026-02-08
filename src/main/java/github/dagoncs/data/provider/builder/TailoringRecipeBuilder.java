package github.dagoncs.data.provider.builder;

import github.dagoncs.recipe.TailoringRecipe;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TailoringRecipeBuilder {
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();

    private TailoringRecipeBuilder(ItemConvertible result, int count) {
        this.result = result.asItem();
        this.count = count;
    }

    public static TailoringRecipeBuilder create(ItemConvertible result) {
        return new TailoringRecipeBuilder(result, 1);
    }

    public static TailoringRecipeBuilder create(ItemConvertible result, int count) {
        return new TailoringRecipeBuilder(result, count);
    }

    public TailoringRecipeBuilder input(ItemConvertible item) {
        return this.input(item, 1);
    }

    public TailoringRecipeBuilder input(ItemConvertible item, int count) {
        for (int i = 0; i < count; i++) {
            this.ingredients.add(Ingredient.ofItems(item));
        }
        return this;
    }

    public TailoringRecipeBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        this.offerTo(exporter, Registries.ITEM.getId(this.result));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        // 1. Create the Custom Recipe Object
        TailoringRecipe recipe = new TailoringRecipe(this.ingredients, new ItemStack(this.result, this.count));

        // 2. Build the Advancement
        // FIX: In 1.21, 'Strategy' is now 'CriterionMerger' and the method is 'criteriaMerger'
        Advancement.Builder advancement = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);

        this.criteria.forEach(advancement::criterion);

        // 3. Export to DataGen
        exporter.accept(recipeId, recipe, advancement.build(recipeId.withPrefixedPath("recipes/tailoring/")));
    }
}