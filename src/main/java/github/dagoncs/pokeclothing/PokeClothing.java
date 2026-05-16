package github.dagoncs.pokeclothing;

import github.dagoncs.pokeclothing.block.entity.ModBlockEntities;
import github.dagoncs.pokeclothing.init.ArmorMaterialInit;
import github.dagoncs.pokeclothing.block.BlockInit;
import github.dagoncs.pokeclothing.init.ItemGroupInit;
import github.dagoncs.pokeclothing.init.ItemInit;
import github.dagoncs.pokeclothing.recipe.ModRecipes;
import github.dagoncs.pokeclothing.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokeClothing implements ModInitializer {
	public static final String MOD_ID = "poke-clothing";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ItemInit.load();
        BlockInit.load();
        ModBlockEntities.load();
		ItemGroupInit.load();
		ArmorMaterialInit.load();
        ModRecipes.registerRecipes();
        ModScreenHandlers.registerScreenHandlers();
		LOGGER.info("Poke Clothing initialized");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}