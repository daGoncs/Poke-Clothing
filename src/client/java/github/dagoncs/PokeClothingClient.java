package github.dagoncs;
import github.dagoncs.config.PokeClothingConfig;
import github.dagoncs.screen.ModScreenHandlers;

import github.dagoncs.screen.TailoringStationScreen;
import github.dagoncs.util.UpdateChecker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PokeClothingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PokeClothingConfig.load();
        UpdateChecker.check();
        HandledScreens.register(ModScreenHandlers.TAILORING_STATION_SCREEN_HANDLER, TailoringStationScreen::new);
        // Register the Join Event to notify the player
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            // The Final Gate Check
            if (PokeClothingConfig.getInstance().checkForUpdates
                    && UpdateChecker.updateFound
                    && !UpdateChecker.hasNotifiedPlayer) {

                // Ensure the player object exists before sending
                if (client.player != null) {

                    // Construct the interactive UI element with the dynamic version URL
                    Text updateText = Text.literal("[Poke Clothing] A new update (" + UpdateChecker.remoteVersionString + ") is available! Click here to download.")
                            .styled(style -> style
                                    .withColor(Formatting.GOLD)
                                    // Concatenate the remote version string to the specific Modrinth version route
                                    .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://modrinth.com/mod/poke-clothing/version/" + UpdateChecker.remoteVersionString))
                                    .withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.literal("Open Modrinth to download version " + UpdateChecker.remoteVersionString + "!")))
                            );

                    // Dispatch the message to the chat (false = not an action bar message)
                    client.player.sendMessage(updateText, false);

                    // Lock the state so it only fires once per session
                    UpdateChecker.hasNotifiedPlayer = true;
                }
            }
        });
    }
}