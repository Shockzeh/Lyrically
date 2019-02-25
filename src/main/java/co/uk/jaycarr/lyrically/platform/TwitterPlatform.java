package co.uk.jaycarr.lyrically.platform;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

import java.util.List;
import java.util.stream.Collectors;

public final class TwitterPlatform implements Platform<Twitter> {

    private final Twitter twitter;

    public TwitterPlatform(Configuration configuration) {
        this.twitter = new TwitterFactory(configuration).getInstance();
    }

    @Override
    public void post(String lyric) {
        try {
            this.twitter.updateStatus(lyric);
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getPreviousPosts() {
        try {
            return this.twitter.getUserTimeline().stream()
                    .map(Status::getText)
                    .collect(Collectors.toList());
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Twitter getProvider() {
        return this.twitter;
    }
}