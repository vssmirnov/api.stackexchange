package stackExchange;

import webapp.model.Order;
import webapp.model.SearchSort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Builder url requestfor the site api.stackechange.com</p>
 */
public class ApiUrlBuilder {
    private final String baseUrl;
    private final LinkedHashMap<String, String> queryStringParameters;

    /**
     * @param apiVersion Version site, example site http://api.stackexchange.com/2.2/search, where version 2.2
     * @param relativeUrl Method site, example site http://api.stackexchange.com/2.2/search, where relativeUrl search
     * @param useHttps if 'true' then protocol https else http
     */
    public ApiUrlBuilder(String apiVersion, String relativeUrl, boolean useHttps)
    {
        baseUrl = String.format("%1$s://api.stackexchange.com/%2$s%3$s%4$s", useHttps ? "https" : "http", apiVersion, relativeUrl.startsWith("/") ? "" : "/", relativeUrl);
        queryStringParameters = new LinkedHashMap<String,String>();
    }

    /**
     * <p>Get url address site</p>
     * @return Full url address site without parameters, for example http://api.stackexchange.com/search
     */
    public String getBaseUrl(){
        return baseUrl;
    }

    /**
     * <p>Add parameter for generated request</p>
     * @param name name
     * @param value value
     */
    public void AddParameter(String name, String value)
    {
        if (value != null)
            queryStringParameters.put(name, value);
    }

    /**
     * <p>Add parameter for generated request</p>
     * @param name name
     * @param value value
     */
    public void AddParameter(String name, Integer value)
    {
        if (value != null)
            queryStringParameters.put(name, value.toString());
    }

    /**
     * <p>Add parameter for generated request</p>
     * @param name name
     * @param value value
     */
    public void AddParameter(String name, Date value)
    {
        if (value != null)
            AddParameter(name, value.toString());
    }

    /**
     * <p>Add parameter for generated request</p>
     * @param name name
     * @param value value
     */
    public void AddParameter(String name, Order value) {
        if (value != null)
            AddParameter(name, value.toString());
    }

    /**
     * <p>Add parameter for generated request</p>
     * @param name name
     * @param value value
     */
    public void AddParameter(String name, SearchSort value) {
        if (value != null)
            AddParameter(name, value.toString());
    }

    /**
     * <p>Builds a string of parameters for the request of http method of POST</p>
     * @return Parameters string
     */
    public String QueryString()
    {
        ArrayList<String> result = new ArrayList<>();

        Consumer<String> formatin = (String key) -> {
            try {
                result.add(String.format("%1$s=%2$s", URLEncoder.encode(key, "UTF-8"), URLEncoder.encode(queryStringParameters.get(key), "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        };

        Set<String> array = queryStringParameters.keySet();
        array.forEach(formatin);
        return String.join("&", result);
    }

    /**
     * Builds a string of parameters for the request of http method of GET
     * @return url address
     */
    @Override
    public String toString(){
        String url = baseUrl;

        if (!queryStringParameters.isEmpty())
            url += "?" + QueryString();

        return url;
    }
}
