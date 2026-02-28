package github.dagoncs.block.entity;


import github.dagoncs.block.entity.custom.TailoringStationBlockEntity;
import github.dagoncs.PokeClothing;
import github.dagoncs.block.BlockInit;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<TailoringStationBlockEntity> TAILORING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(PokeClothing.MOD_ID, "tailoring_station_be"),
                    BlockEntityType.Builder.create(TailoringStationBlockEntity::new, BlockInit.TAILORING_STATION).build(null));


    public static void load() {
        PokeClothing.LOGGER.info("Registering Block Entities for " + PokeClothing.MOD_ID);
    }
}