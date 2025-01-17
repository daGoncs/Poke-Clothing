package github.dagoncs;

import github.dagoncs.init.ArmorMaterialInit;
import github.dagoncs.init.ItemGroupInit;
import github.dagoncs.init.ItemInit;
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
		ItemGroupInit.load();
		ArmorMaterialInit.load();
		LOGGER.info("Poke Clothing initialized");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}