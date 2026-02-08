package github.dagoncs.screen;

import github.dagoncs.PokeClothing;
import github.dagoncs.screen.custom.TailoringStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<TailoringStationScreenHandler> TAILORING_STATION_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(PokeClothing.MOD_ID, "tailoring_station_screen_handler"),
                    new ExtendedScreenHandlerType<>(TailoringStationScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        PokeClothing.LOGGER.info("Registering Screen Handlers for " + PokeClothing.MOD_ID);
    }
}