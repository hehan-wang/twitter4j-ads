package twitter4jads;

import twitter4jads.conf.ConfigurationBuilder;

/**
 * User: abhishekanand
 * Date: 10/05/16 10:49 PM.
 */
public class BaseAdsTest {
    public static String accountId = "18ce558da3u";
    public static TwitterAds getTwitterAdsInstance() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerSecret("NzxuUBChudFIsOD1qY8R56mLG3ehvMxtmk68ZbGfAdoCDSw8Rx").setOAuthConsumerKey("xxx").setOAuthAccessToken("xxx").setOAuthAccessTokenSecret("xx").setHttpRetryCount(0).setHttpConnectionTimeout(5000);
        return new TwitterAdsFactory(configurationBuilder.build()).getAdsInstance();
    }


}
