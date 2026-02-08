package github.dagoncs.data.provider;

import github.dagoncs.init.BlockInit;
import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class PokeClothingModelProvider extends FabricModelProvider {
    public PokeClothingModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        // 1. Define your custom textures
        TextureMap mapping = new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_front"))
                .put(TextureKey.SIDE, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_front"))
                .put(TextureKey.TOP, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_bottom"));

        // 2. Create the Model and Upload it
        // This generates "assets/poke-clothing/models/block/tailoring_station.json"
        Identifier modelId = TexturedModel.makeFactory(b -> mapping, Models.ORIENTABLE_WITH_BOTTOM)
                .upload(BlockInit.TAILORING_STATION, generator.modelCollector);

        // 3. Register the Rotation Logic
        // This generates "assets/poke-clothing/blockstates/tailoring_station.json"
        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(BlockInit.TAILORING_STATION, BlockStateVariant.create().put(VariantSettings.MODEL, modelId))
                        .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ItemInit.WHITE_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.LIGHT_GRAY_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GRAY_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BLACK_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BROWN_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.RED_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.ORANGE_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.YELLOW_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.LIME_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.GREEN_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.CYAN_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.LIGHT_BLUE_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BLUE_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.PURPLE_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.MAGENTA_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.PINK_CLOTH, Models.GENERATED);
        itemModelGenerator.register(ItemInit.KANTO_ASH_HELMET, Models.GENERATED);
        itemModelGenerator.register(ItemInit.KANTO_ASH_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.KANTO_ASH_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.KANTO_ASH_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.MISTY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.MISTY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.MISTY_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BROCK_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BROCK_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.BROCK_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.TEAM_ROCKET_GRUNT_HELMET, Models.GENERATED);
        itemModelGenerator.register(ItemInit.TEAM_ROCKET_GRUNT_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ItemInit.TEAM_ROCKET_GRUNT_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ItemInit.TEAM_ROCKET_GRUNT_BOOTS, Models.GENERATED);
    }
}
