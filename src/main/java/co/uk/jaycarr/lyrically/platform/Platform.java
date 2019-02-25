package co.uk.jaycarr.lyrically.platform;

import java.util.List;

public interface Platform<T> {

    void post(String lyric);

    List<String> getPreviousPosts();

    T getProvider();
}