package github.dagoncs;

import github.dagoncs.pokeclothing.provider.PokeClothingModelProvider;
import github.dagoncs.pokeclothing.provider.PokeClothingRecipeProvider;
import github.dagoncs.pokeclothing.provider.PokeClothingTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PokeClothingDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(PokeClothingModelProvider::new);
		pack.addProvider(PokeClothingRecipeProvider::new);
		pack.addProvider(PokeClothingTagProvider::new);
	}
}
