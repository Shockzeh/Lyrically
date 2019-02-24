package co.uk.jaycarr.lyrically.config;

public interface Config {

    boolean isDebug();

    int getInterval();

    boolean isQuoteWrap();

    String[] getLyrics();
}