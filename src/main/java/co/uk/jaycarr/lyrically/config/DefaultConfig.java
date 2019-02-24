package co.uk.jaycarr.lyrically.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DefaultConfig implements Config {

    private final boolean debug;
    private final int interval;
    private final boolean quoteWrap;
    private final String[] lyrics;

    public DefaultConfig(Path configPath) {
        try (Reader reader = Files.newBufferedReader(configPath)) {
            Gson gson = new Gson();
            JsonObject object = gson.fromJson(reader, JsonObject.class);
            this.debug = object.get("debug").getAsBoolean();
            this.interval = object.get("interval").getAsInt();
            this.quoteWrap = object.get("quote-wrap").getAsBoolean();
            this.lyrics = gson.fromJson(object.getAsJsonArray("lyrics"), String[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isDebug() {
        return this.debug;
    }

    @Override
    public int getInterval() {
        return this.interval;
    }

    @Override
    public boolean isQuoteWrap() {
        return this.quoteWrap;
    }

    @Override
    public String[] getLyrics() {
        return this.lyrics;
    }
}