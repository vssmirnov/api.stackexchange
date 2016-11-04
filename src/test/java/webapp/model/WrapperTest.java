package webapp.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import stackExchange.ApiStackExchangeBase;
import stackExchange.SearchApiStackExchange;
import stackExchange.StackExchangeResponse;

import java.io.IOException;

/**
 * Created by vssmirnov on 04.11.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ApiStackExchangeBase.class)
public class WrapperTest {

    SearchApiStackExchange searchApiStackExchange;

    @Before
    public void setUp() throws Exception {
        searchApiStackExchange = PowerMockito.mock(SearchApiStackExchange.class);
        String result = "{\\\"items\\\":[{\\\"tags\\\":[\\\"c\\\",\\\"gcc\\\",\\\"linker\\\",\\\"libraries\\\"],\\\"owner\\\":{\\\"reputation\\\":434,\\\"user_id\\\":1071669,\\\"user_type\\\":\\\"registered\\\",\\\"accept_rate\\\":42,\\\"profile_image\\\":\\\"https:\\/\\/www.gravatar.com\\/avatar\\/701fc95be1eaf05adaccd367ba33ec9b?s=128/&d=identicon/&r=PG\\\",\\\"display_name\\\":\\\"dargaud\\\",\\\"link\\\":\\\"http:\\/\\/stackoverflow.com\\/users\\/1071669\\/dargaud\\\"},\\\"is_answered\\\":true,\\\"view_count\\\":40,\\\"accepted_answer_id\\\":40419576,\\\"answer_count\\\":2,\\\"score\\\":-1,\\\"last_activity_date\\\":1478257640,\\\"creation_date\\\":1478251186,\\\"question_id\\\":40418988,\\\"link\\\":\\\"http:\\/\\/stackoverflow.com\\/questions\\/40418988\\/how-to-test-if-a-c-function-is-linkable\\\",\\\"title\\\":\\\"How to test if a C function is linkable\\\"}],\\\"has_more\\\":true,\\\"quota_max\\\":300,\\\"quota_remaining\\\":291}";
        String apiUrl = "http://api.stackexchange.com/2.2/search?site=stackoverflow.com&pagesize=1&intitle=Test";
        PowerMockito.when(searchApiStackExchange, "fetchResponseWithGet", apiUrl).thenReturn(result);
    }

    @Test
    public void WrapperGetTest() throws IOException {
        SearchApiStackExchange client = searchApiStackExchange;

        StackExchangeResponse<Wrapper<Question>> response = client.GetMatches("stackoverflow.com", null, null, null, null, null, null, null ,null, null, null, null, "Test");
    }
}
