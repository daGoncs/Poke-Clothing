package github.dagoncs.compat;

import github.dagoncs.pokeclothing.block.BlockInit;
import github.dagoncs.pokeclothing.recipe.ModRecipes;
import github.dagoncs.pokeclothing.recipe.TailoringRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class PokeClothingREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new TailoringCategory());

        registry.addWorkstations(TailoringCategory.TAILORING, EntryStacks.of(BlockInit.TAILORING_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(
                TailoringRecipe.class,
                ModRecipes.TAILORING_TYPE,
                TailoringDisplay::new
        );
    }

    @Override
    public double getPriority() {return -1000.0;}
}