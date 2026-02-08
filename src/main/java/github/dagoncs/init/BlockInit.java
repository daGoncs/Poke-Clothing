package github.dagoncs.init;


import github.dagoncs.PokeClothing;
import github.dagoncs.block.custom.TailoringStation;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockInit {
    public static final Block TAILORING_STATION = registerBlock("tailoring_station",
            new TailoringStation(AbstractBlock.Settings.create()));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PokeClothing.MOD_ID, name), block);
    }
    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PokeClothing.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void load() {
        PokeClothing.LOGGER.info("Registering BlockInit");
    }
}
