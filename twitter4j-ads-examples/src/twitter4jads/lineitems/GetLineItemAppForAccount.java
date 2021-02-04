package twitter4jads.lineitems;

import com.google.api.client.util.Lists;
import twitter4jads.BaseAdsListResponse;
import twitter4jads.BaseAdsListResponseIterable;
import twitter4jads.BaseAdsTest;
import twitter4jads.TwitterAds;
import twitter4jads.api.TwitterAdsLineItemApi;
import twitter4jads.internal.models4j.TwitterException;
import twitter4jads.models.ads.LineItem;
import twitter4jads.models.ads.LineItemAppResponse;
import twitter4jads.models.ads.sort.LineItemsSortByField;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: shivraj
 * Date: 12/05/16 2:08 PM.
 */
public class GetLineItemAppForAccount extends BaseAdsTest {

    public static void main(String[] args) throws TwitterException {
        TwitterAds client = getTwitterAdsInstance();
        List<LineItem> res = doPage(cursor -> client.getLineItemApi().getAllLineItems(accountId, null, null, null, Optional.of(1000), true, true, cursor, null, null));
        System.out.println(res);
    }
}
