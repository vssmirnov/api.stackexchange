package webapp.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import stackExchange.IHTTPMethodRequest;
import stackExchange.SearchApiStackExchange;
import stackExchange.StackExchangeResponse;

import java.io.IOException;
import java.security.acl.Owner;
import java.util.Date;

/**
 * Created by vssmirnov on 04.11.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(IHTTPMethodRequest.class)
public class WrapperTest {

    @Mock
    IHTTPMethodRequest methodRequest;
    SearchApiStackExchange searchApiStackExchange;

    @Before
    public void setUp() throws Exception {
        methodRequest = PowerMockito.mock(IHTTPMethodRequest.class);
        searchApiStackExchange = new SearchApiStackExchange("2.2", methodRequest);
        String result = "{\"items\":[{\"tags\":[\"c\",\"gcc\",\"linker\",\"libraries\"],\"owner\":{\"reputation\":434,\"user_id\":1071669,\"user_type\":\"registered\",\"accept_rate\":42,\"profile_image\":\"https:\\/\\/www.gravatar.com\\/avatar\\/701fc95be1eaf05adaccd367ba33ec9b?s=128/&d=identicon/&r=PG\",\"display_name\":\"dargaud\",\"link\":\"http:\\/\\/stackoverflow.com\\/users\\/1071669\\/dargaud\"},\"is_answered\":true,\"view_count\":40,\"accepted_answer_id\":40419576,\"answer_count\":2,\"score\":-1,\"last_activity_date\":1478257640,\"creation_date\":1478251186,\"question_id\":40418988,\"link\":\"http:\\/\\/stackoverflow.com\\/questions\\/40418988\\/how-to-test-if-a-c-function-is-linkable\",\"title\":\"How to test if a C function is linkable\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":291}";
        String apiUrl = "http://api.stackexchange.com/2.2/search?site=stackoverflow.com&pagesize=1&intitle=Test";
        PowerMockito.when(methodRequest, "fetchResponseWithGet", apiUrl).thenReturn(result);
    }

    @Test
    public void WrapperGetTest() throws IOException {
        StackExchangeResponse<Question> response = searchApiStackExchange.GetMatches("stackoverflow.com", null, null, 1, null, null, null, null ,null, null, null, null, "Test");
        Wrapper data = response.getWrapper();
        Question question = (Question)data.getItems()[0];
        ShallowUser owner = question.getOwner();
        Assert.assertEquals(question.getTitle(),"How to test if a C function is linkable");
        Assert.assertArrayEquals(question.getTags(),new String[]{"c", "gcc", "linker", "libraries"});
        Assert.assertEquals(owner.getDisplayName(),"dargaud");
        Assert.assertEquals(question.getAnswered(),Boolean.TRUE);
        Assert.assertEquals(question.getLastActivityDate(), new Date(1478257640));
        Assert.assertEquals(question.getCreationDate(), new Date(1478251186));
    }
}
