package github.dagoncs.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import github.dagoncs.PokeClothing;
import github.dagoncs.config.PokeClothingConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;

public class UpdateChecker {
    private static final Gson GSON = new Gson();

    // Session State Management
    public static boolean hasNotifiedPlayer = false;
    public static boolean updateFound = false;
    public static String remoteVersionString = "";

    /**
     * Kicks off the async update check if enabled in the config.
     */
    public static void check() {
        // Gate check against our config
        if (!PokeClothingConfig.getInstance().checkForUpdates) {
            return;
        }

        // Fetch the mod container to get the actual Fabric Version object
        FabricLoader.getInstance().getModContainer(PokeClothing.MOD_ID).ifPresent(container -> {
            Version localVersion = container.getMetadata().getVersion();

            // Execute the async network request
            ModrinthApiClient.fetchLatestVersionJson().thenAccept(jsonOpt -> {
                if (jsonOpt.isPresent()) {
                    try {
                        // Parse the JSON array
                        JsonArray versionsArray = GSON.fromJson(jsonOpt.get(), JsonArray.class);

                        if (!versionsArray.isEmpty()) {
                            JsonObject latestRelease = versionsArray.get(0).getAsJsonObject();
                            remoteVersionString = latestRelease.get("version_number").getAsString();

                            // Parse the remote string into a Fabric Version object
                            Version remoteVersion = Version.parse(remoteVersionString);

                            // Semantic comparison: > 0 means the remote version is strictly newer
                            if (remoteVersion.compareTo(localVersion) > 0) {
                                updateFound = true;
                                PokeClothing.LOGGER.info("Poke Clothing Update Found! Latest version: " + remoteVersionString);
                            } else {
                                PokeClothing.LOGGER.info("Poke Clothing is up to date (or ahead of public release).");
                            }
                        }
                    } catch (Exception e) {
                        PokeClothing.LOGGER.debug("Failed to parse Modrinth update JSON or compare versions.", e);
                    }
                }
            });
        });
    }
}