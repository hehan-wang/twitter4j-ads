package twitter4jads.promotedtweets;

import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.Tweet;
import twitter4jads.models.ads.TwitterTweetType;

import java.util.List;

public class GetTweets extends BaseAdsTest {
    public static void main(String[] args) throws TwitterException {
        TwitterAds ads = getTwitterAdsInstance();
        BaseAdsListResponse<Tweet> tweets = ads.getTweetsApi().getTweets(accountId, TwitterTweetType.PUBLISHED, 1000, null, null, null, null, null, null);
        List<Tweet> data = tweets.getData();
        System.out.println(data);
    }
}
