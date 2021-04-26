package twitter4jads.stats;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.api.TwitterAdsStatApi;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.Granularity;
import twitter4jads.models.ads.Placement;
import twitter4jads.models.ads.TwitterActiveEntitiesEntity;
import twitter4jads.models.ads.TwitterEntityStatistics;
import twitter4jads.models.ads.TwitterEntityType;

import java.util.ArrayList;
import java.util.List;

/**
 * User: shivraj
 * Date: 12/05/16 2:08 PM.
 */
public class GetActiveEntitiesForAccount extends BaseAdsTest {

    public static void main(String[] args) {
        TwitterAds twitterAdsInstance = getTwitterAdsInstance();
        TwitterAdsStatApi statApi = twitterAdsInstance.getStatApi();
        long until = DateTime.parse("2020-09-03").getMillis();
        long since = DateTime.parse("2020-09-02").getMillis();
        List<TwitterActiveEntitiesEntity> data = new ArrayList<>();
        try {
            BaseAdsListResponseIterable<TwitterActiveEntitiesEntity> resp = statApi.fetchActiveEntities(accountId, TwitterEntityType.LINE_ITEM, since, until);
            for (BaseAdsListResponse<TwitterActiveEntitiesEntity> r : resp) {
                data.addAll(r.getData());
            }
            System.out.println(data);
        } catch (TwitterException e) {
            e.printStackTrace();
            System.err.println(e.getErrorMessage());
        }
    }
}
