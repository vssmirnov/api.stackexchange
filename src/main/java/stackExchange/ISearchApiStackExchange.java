package stackExchange;

import webapp.model.Order;
import webapp.model.Question;
import webapp.model.SearchSort;
import webapp.model.Wrapper;

import java.io.IOException;
import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public interface ISearchApiStackExchange {
    StackExchangeResponse<Wrapper<Question>> GetMatches(
            String site, String filter, Integer page, Integer pagesize, Date fromdate,
            Date todate, SearchSort sort, Date mindate, Date maxdate, Order order,
            String tagged, String nottagged, String intitle) throws IOException;
}
