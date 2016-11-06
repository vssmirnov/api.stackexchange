package stackExchange;

import webapp.model.Order;
import webapp.model.Question;
import webapp.model.SearchSort;

import java.io.IOException;
import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Interface method search of the site api.stackexchange.com</p>
 */
public interface ISearchApiStackExchange {
    /**
     * The method search for getting data from the site api.stackexchange.com
     * @param site
     * @param filter
     * @param page
     * @param pagesize
     * @param fromdate
     * @param todate
     * @param sort
     * @param mindate
     * @param maxdate
     * @param order
     * @param tagged
     * @param nottagged
     * @param intitle
     * @return Wrapper of response from the site
     * @throws IOException
     */
    StackExchangeResponse<Question> GetMatches(
            String site, String filter, Integer page, Integer pagesize, Date fromdate,
            Date todate, SearchSort sort, Date mindate, Date maxdate, Order order,
            String tagged, String nottagged, String intitle) throws IOException;
}
