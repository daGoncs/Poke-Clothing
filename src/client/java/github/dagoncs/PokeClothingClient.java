package github.dagoncs;
import github.dagoncs.screen.ModScreenHandlers;

import github.dagoncs.screen.TailoringStationScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class PokeClothingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.TAILORING_STATION_SCREEN_HANDLER, TailoringStationScreen::new);
    }
}