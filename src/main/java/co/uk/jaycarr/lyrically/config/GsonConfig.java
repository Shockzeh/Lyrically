package co.uk.jaycarr.lyrically.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class GsonConfig implements Config {

    private final boolean debug;
    private final int interval;
    private final boolean quoteWrap;
    private final String[] lyrics;

    public GsonConfig(Gson gson, JsonObject object) {
        this.debug = object.get("debug").getAsBoolean();
        this.interval = object.get("interval").getAsInt();
        this.quoteWrap = object.get("quote-wrap").getAsBoolean();
        this.lyrics = gson.fromJson(object.getAsJsonArray("lyrics"), String[].class);
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