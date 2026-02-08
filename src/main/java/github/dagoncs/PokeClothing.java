package github.dagoncs;

import github.dagoncs.block.entity.ModBlockEntities;
import github.dagoncs.init.ArmorMaterialInit;
import github.dagoncs.init.BlockInit;
import github.dagoncs.init.ItemGroupInit;
import github.dagoncs.init.ItemInit;
import github.dagoncs.recipe.ModRecipes;
import github.dagoncs.screen.ModScreenHandlers;
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