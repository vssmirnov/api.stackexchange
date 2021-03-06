package webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import stackExchange.SearchApiStackExchange;
import stackExchange.StackExchangeResponse;
import webapp.model.Question;
import webapp.model.Wrapper;

import java.io.IOException;

/**
 * Created by vssmirnov on 01.11.2016.
 */
@Controller
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainView() {
        LOGGER.info("Rendering main view.");
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, params = {"intitle"})
    public String searchText(@RequestParam(value = "intitle") String intitle, ModelMap map) throws IOException {
        LOGGER.info(intitle);

        SearchApiStackExchange searchApiStackExchange = new SearchApiStackExchange("2.2");
        StackExchangeResponse<Wrapper<Question>> response = searchApiStackExchange.GetMatches(
                "stackoverflow.com", null, null, null,
                null, null, null,
                null ,null, null, null, null, intitle);

        map.addAttribute("ResultMessage", response.getData());
        LOGGER.info(response.getApiUrl());
        return "index";
    }
}
