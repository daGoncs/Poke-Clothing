package github.dagoncs.data.provider;

import github.dagoncs.PokeClothing;
import github.dagoncs.block.BlockInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class PokeClothingModelProvider extends FabricModelProvider {
    public PokeClothingModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        TextureMap mapping = new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_front"))
                .put(TextureKey.SIDE, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_front"))
                .put(TextureKey.TOP, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_top"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(BlockInit.TAILORING_STATION, "_bottom"));

        Identifier modelId = TexturedModel.makeFactory(b -> mapping, Models.ORIENTABLE_WITH_BOTTOM)
                .upload(BlockInit.TAILORING_STATION, generator.modelCollector);

        generator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(BlockInit.TAILORING_STATION, BlockStateVariant.create().put(VariantSettings.MODEL, modelId))
                        .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item item : Registries.ITEM) {
            Identifier id = Registries.ITEM.getId(item);
            if (id.getNamespace().equals(PokeClothing.id("dummy").getNamespace())) {

                if (item instanceof ArmorItem || id.getPath().endsWith("_cloth") || id.getPath().equals("ash_cap_icon")) {
                    itemModelGenerator.register(item, Models.GENERATED);
                }

            }
        }
    }
}