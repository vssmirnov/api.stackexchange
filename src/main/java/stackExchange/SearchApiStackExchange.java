package stackExchange;

import org.codehaus.jackson.type.JavaType;
import webapp.model.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class SearchApiStackExchange extends ApiStackExchangeBase<Question> implements ISearchApiStackExchange {
    public SearchApiStackExchange(String version) {
        super(version);
    }

    public SearchApiStackExchange(){
        super("2.2");
    }

    @Override
    protected JavaType getType() {
        Wrapper<Question> wrapper = new Wrapper<Question>();
        return objectMapper.getTypeFactory().constructType(wrapper.getClass());
    }

    @Override
    public StackExchangeResponse<Wrapper<Question>> GetMatches(String site, String filter, Integer page, Integer pagesize, Date fromdate, Date todate, SearchSort sort, Date mindate, Date maxdate, Order order, String tagged, String nottagged, String intitle) throws IOException {
        ValidateString(site, "site");

        ApiUrlBuilder urlBuilder = new ApiUrlBuilder(version, "/search", false);

        urlBuilder.AddParameter("site", site);
        urlBuilder.AddParameter("filter", filter);
        urlBuilder.AddParameter("page", page);
        urlBuilder.AddParameter("pagesize", 1);
        urlBuilder.AddParameter("fromdate", fromdate);
        urlBuilder.AddParameter("todate", todate);
        urlBuilder.AddParameter("sort", sort);
        urlBuilder.AddParameter("min", mindate);
        urlBuilder.AddParameter("max", maxdate);
        urlBuilder.AddParameter("order", order);
        urlBuilder.AddParameter("tagged", tagged);
        urlBuilder.AddParameter("nottagged", nottagged);
        urlBuilder.AddParameter("intitle", intitle);

        return GetResponse(urlBuilder, HttpMethod.GET, "/search");
    }
}
