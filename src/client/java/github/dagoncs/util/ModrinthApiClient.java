package github.dagoncs.util;

import github.dagoncs.pokeclothing.PokeClothing;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModrinthApiClient {

    // We strictly encode the JSON arrays for the query parameters:
    // loaders=["fabric"] -> %5B%22fabric%22%5D
    // game_versions=["1.21.1"] -> %5B%221.21.1%22%5D
    private static final String MODRINTH_API_URL =
            "https://api.modrinth.com/v2/project/poke-clothing/version" +
                    "?loaders=%5B%22fabric%22%5D&game_versions=%5B%221.21.1%22%5D";

    // Build a static client with a short timeout to prevent hanging threads
    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    /**
     * Fetches the latest version JSON array from Modrinth asynchronously.
     * Returns an empty Optional if the request times out, fails, or returns a non-200 status.
     */
    public static CompletableFuture<Optional<String>> fetchLatestVersionJson() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(MODRINTH_API_URL))
                        // Modrinth strictly requests a unique User-Agent to avoid rate limiting blocks
                        .header("User-Agent", "daGoncs/poke-clothing/1.21.1 (github.com/daGoncs)")
                        .timeout(Duration.ofSeconds(5))
                        .GET()
                        .build();

                HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    return Optional.of(response.body());
                } else {
                    PokeClothing.LOGGER.warn("Update check returned non-200 status: " + response.statusCode());
                    return Optional.empty();
                }
            } catch (Exception e) {
                // Fail silently as requested (IOException, InterruptedException, etc.)
                // We log at debug level so it doesn't spam standard user console logs if their internet drops.
                PokeClothing.LOGGER.debug("Failed to ping Modrinth API for updates.", e);
                return Optional.empty();
            }
        });
    }
}