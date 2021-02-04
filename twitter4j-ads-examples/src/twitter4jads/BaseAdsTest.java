package twitter4jads;

import twitter4jads.conf.ConfigurationBuilder;
import twitter4jads.internal.models4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * User: abhishekanand
 * Date: 10/05/16 10:49 PM.
 */
public class BaseAdsTest {
    public static String accountId = "18ce558da3u";

    public static TwitterAds getTwitterAdsInstance() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder
                .setOAuthConsumerKey("yQcSxX3nBOx35Na5cMv2hJh8g")
                .setOAuthConsumerSecret("NzxuUBChudFIsOD1qY8R56mLG3ehvMxtmk68ZbGfAdoCDSw8Rx")
                .setOAuthAccessToken("1291673676434137089-uUvbfpQvh0Ll0t0x1tC8mGmJQ0dNrS")
                .setOAuthAccessTokenSecret("uarjBikhDm5mvOWQMifoPwDBxfAXfO9LQ1BRHvx0DZ5VP")
                .setHttpRetryCount(0).setHttpConnectionTimeout(5000);
        return new TwitterAdsFactory(configurationBuilder.build()).getAdsInstance();
    }

    public static <T> List<T> doPageIterable(TwitterSender<String, BaseAdsListResponseIterable<T>> sender) {
        List<T> res = new ArrayList<>();
        String cursor = "";
        do {//有下一页继续请求
            try {
                BaseAdsListResponseIterable<T> l = sender.send(cursor);
                if (l.hasData()) {
                    List<T> collect = StreamSupport.stream(l.spliterator(), false).flatMap(s -> s.getData().stream()).collect(Collectors.toList());
                    res.addAll(collect);
                }
                cursor = l.getNextCursor();
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        } while (cursor != null && !"".equals(cursor));
        return res;
    }

    public static <T> List<T> doPage(TwitterSender<String, BaseAdsListResponseIterable<T>> sender) throws TwitterException {
        List<T> res = new ArrayList<>();
        String cursor = "";
        do {//有下一页继续请求
            BaseAdsListResponseIterable<T> l = sender.send(cursor);
            if (l.hasData()) {
                List<T> collect = StreamSupport.stream(l.spliterator(), false).flatMap(s -> s.getData().stream()).collect(Collectors.toList());
                res.addAll(collect);
            }
            cursor = l.getNextCursor();
        } while (cursor != null && !"".equals(cursor));
        return res;
    }

    @FunctionalInterface
    public interface TwitterSender<C, R> {
        R send(C cursor) throws TwitterException;
    }
}
