package co.uk.jaycarr.lyrically;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Lyrically {

    public static void main(String[] args) {
        try {
            Path path = Paths.get(Lyrically.class.getResource("/config.json").toURI());
            // Config config = new DefaultConfig(path);

            /*
            for (String lyric : config.getLyrics()) {
                System.out.println(lyric);
            }*/
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}