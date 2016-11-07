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
     * @param site site
     * @param filter filter
     * @param page page
     * @param pagesize pagesize
     * @param fromdate fromdate
     * @param todate todate
     * @param sort sort
     * @param mindate mindate
     * @param maxdate maxdate
     * @param order order
     * @param tagged tagged
     * @param nottagged nottagged
     * @param intitle intitle
     * @return Wrapper of response from the site
     * @throws IOException Any exception
     */
    StackExchangeResponse<Question> GetMatches(
            String site, String filter, Integer page, Integer pagesize, Date fromdate,
            Date todate, SearchSort sort, Date mindate, Date maxdate, Order order,
            String tagged, String nottagged, String intitle) throws IOException;
}
