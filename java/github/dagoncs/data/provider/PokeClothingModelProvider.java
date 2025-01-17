package github.dagoncs.data.provider;

import github.dagoncs.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class PokeClothingModelProvider extends FabricModelProvider {
    public PokeClothingModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

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
