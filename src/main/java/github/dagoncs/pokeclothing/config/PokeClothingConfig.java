package github.dagoncs.pokeclothing.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import github.dagoncs.pokeclothing.PokeClothing;
import net.fabricmc.loader.api.FabricLoader;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class PokeClothingConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("poke-clothing.json");

    // Config field
    public boolean checkForUpdates = true;

    private static PokeClothingConfig instance = new PokeClothingConfig();

    public static PokeClothingConfig getInstance() {
        return instance;
    }

    /**
     * Attempts to load the configuration file.
     * If it fails or the file doesn't exist, it fails silently and generates a default.
     */
    public static void load() {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                instance = GSON.fromJson(reader, PokeClothingConfig.class);
                // Fallback in case of an empty or entirely malformed JSON file returning null
                if (instance == null) {
                    instance = new PokeClothingConfig();
                    save();
                }
            } catch (Exception e) {
                // Fails silently for the user, but we should log it for our own sanity
                PokeClothing.LOGGER.warn("Failed to read config, generating default.", e);
                instance = new PokeClothingConfig();
                save();
            }
        } else {
            save(); // Generate the default config file silently
        }
    }

    /**
     * Serializes the current instance state to the JSON file.
     */
    public static void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(instance, writer);
        } catch (Exception e) {
            PokeClothing.LOGGER.error("Failed to save config.", e);
        }
    }
}