package webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import stackExchange.HTTPMethodRequest;
import stackExchange.SearchApiStackExchange;
import stackExchange.StackExchangeResponse;
import webapp.model.Question;
import webapp.model.Wrapper;

import java.io.IOException;

/**
 * Created by vssmirnov on 01.11.2016.
 * <p>Main controller for display "input text" and "table" </p>
 */
@Controller
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    /**
     * Display view
     * @return index.jsp without table data
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainView() {
        LOGGER.info("Rendering main view.");
        return "index";
    }

    /**
     * Display view
     * @param intitle Input parameter obtained from the user
     * @param map Model map
     * @return index.jsp with table data
     * @throws IOException Any exception
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET, params = {"intitle"})
    public String searchText(@RequestParam(value = "intitle") String intitle, ModelMap map) throws IOException {
        LOGGER.info(intitle);

        SearchApiStackExchange searchApiStackExchange = new SearchApiStackExchange("2.2", new HTTPMethodRequest());
        StackExchangeResponse<Question> response = searchApiStackExchange.GetMatches(
                "stackoverflow.com", null, null, null,
                null, null, null,
                null ,null, null, null, null, intitle);

        map.addAttribute("ResultMessage", response.getWrapper());
        LOGGER.info(response.getApiUrl());
        return "index";
    }
}
