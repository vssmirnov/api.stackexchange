package stackExchange;

import webapp.model.Order;
import webapp.model.SearchSort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Consumer;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class ApiUrlBuilder {
    private final String baseUrl;
    private final LinkedHashMap<String, String> queryStringParameters;

    public ApiUrlBuilder(String apiVersion, String relativeUrl, boolean useHttps)
    {
        baseUrl = String.format("%1$s://api.stackexchange.com/%2$s%3$s%4$s", useHttps ? "https" : "http", apiVersion, relativeUrl.startsWith("/") ? "" : "/", relativeUrl);
        queryStringParameters = new LinkedHashMap<String,String>();
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public void AddParameter(String name, String value)
    {
        if (value != null)
            queryStringParameters.put(name, value);
    }

    public void AddParameter(String name, Integer value)
    {
        if (value != null)
            queryStringParameters.put(name, value.toString());
    }

    public void AddParameter(String name, Date value)
    {
        if (value != null)
            AddParameter(name, value.toString());
    }

    public void AddParameter(String name, List<String> values)
    {
        if (values != null && !values.isEmpty())
            AddParameter(name, String.join(";", values));
    }

    public void AddParameter(String name, Order value) {
        if (value != null)
            AddParameter(name, value.toString());
    }

    public void AddParameter(String name, SearchSort value) {
        if (value != null)
            AddParameter(name, value.toString());
    }

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

    @Override
    public String toString(){
        String url = baseUrl;

        if (!queryStringParameters.isEmpty())
            url += "?" + QueryString();

        return url;
    }
}
