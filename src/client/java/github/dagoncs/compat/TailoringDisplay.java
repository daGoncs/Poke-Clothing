package github.dagoncs.compat;

import github.dagoncs.recipe.TailoringRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry; // <--- NEW IMPORT
import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TailoringDisplay extends BasicDisplay {

    public TailoringDisplay(RecipeEntry<TailoringRecipe> entry) {

        super(condenseIngredients(entry.value().getIngredients()),
                Collections.singletonList(EntryIngredients.of(entry.value().getResult(BasicDisplay.registryAccess()))),
                Optional.of(entry.id()));
    }

    /**
     * Helper method to group identical ingredients together.
     * Turns [Wool, Wool, Wool] into [3x Wool]
     */
    private static List<EntryIngredient> condenseIngredients(DefaultedList<Ingredient> originalIngredients) {
        List<EntryIngredient> condensedList = new ArrayList<>();
        List<Ingredient> leftovers = new ArrayList<>(originalIngredients);

        while (!leftovers.isEmpty()) {
            Ingredient current = leftovers.remove(0);
            int count = 1;

            for (int i = leftovers.size() - 1; i >= 0; i--) {
                Ingredient other = leftovers.get(i);
                if (match(current, other)) {
                    count++;
                    leftovers.remove(i);
                }
            }

            int finalCount = count;
            condensedList.add(EntryIngredients.ofItemStacks(
                    List.of(current.getMatchingStacks()).stream()
                            .map(stack -> {
                                ItemStack copy = stack.copy();
                                copy.setCount(finalCount);
                                return copy;
                            })
                            .toList()
            ));
        }

        return condensedList;
    }

    private static boolean match(Ingredient a, Ingredient b) {
        ItemStack[] stacksA = a.getMatchingStacks();
        ItemStack[] stacksB = b.getMatchingStacks();
        if (stacksA.length == 0 || stacksB.length == 0) return false;

        // Simple check: if the first item in the list matches, the ingredients are likely the same
        return ItemStack.areItemsEqual(stacksA[0], stacksB[0]);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return TailoringCategory.TAILORING;
    }
}