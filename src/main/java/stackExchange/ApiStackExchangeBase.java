package stackExchange;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import webapp.model.HttpMethod;
import webapp.model.Question;
import webapp.model.Wrapper;


/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Base class implements methods site api.stackexchange.com</p>
 */
public abstract class ApiStackExchangeBase<T> {
    private final int apiTimeoutMs;
    private final int maxSimultaneousRequests;
    private final boolean respectBackoffs;
    protected final ObjectMapper objectMapper;
    protected String version;
    private IHTTPMethodRequest httpMethodRequest;

    /**
     * @param version Version site, example site http://api.stackexchange.com/2.2/search, where version 2.2
     * @param httpMethodRequest
     */
    public ApiStackExchangeBase(String version, IHTTPMethodRequest httpMethodRequest){
        this.version = version;
        this.httpMethodRequest = httpMethodRequest;
        apiTimeoutMs = 5000;
        maxSimultaneousRequests = 10;
        respectBackoffs = true;
        objectMapper = new ObjectMapper();
    }

    /**
     * <p>The main method for getting data from the site api.stackexchange.com</p>
     * @param urlBuilder Builder url request for site api.stackexchange.com
     * @param httpMethod HTTP method GET or POST
     * @return Wrapper of response from the site
     * @throws IOException Any exception
     */
    protected StackExchangeResponse<T> GetResponse(ApiUrlBuilder urlBuilder, HttpMethod httpMethod) throws IOException {
        StackExchangeResponse response = new StackExchangeResponse<Wrapper<T>>();
        try
        {
            if (httpMethod == HttpMethod.POST){
                response.setApiUrl(urlBuilder.getBaseUrl());
                response.setRawData(httpMethodRequest.fetchResponseWithPost(response.getApiUrl(), urlBuilder.QueryString()));
            }
            else {
                response.setApiUrl(urlBuilder.toString());
                response.setRawData(httpMethodRequest.fetchResponseWithGet(response.getApiUrl()));

                String itemsJson = GetItemsJson(response.getRawData());
                objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                ArrayList<Question> list = objectMapper.readValue(itemsJson, getTypeGenericClass());
                String wrapperJson = RemoveItemsJson(response.getRawData());
                Wrapper wrapper = objectMapper.readValue(wrapperJson, getTypeWrapper());
                wrapper.setItems(list.toArray());

                response.setWrapper(wrapper);
                response.setSucces(true);
            }
        }
        catch (Exception ex){
            response.setSucces(false);
            response.setError(ex);
        }
        finally
        {
            return response;
        }
    }

    /**
     * <p>Hack: deserialize using generic in class Wrapper</p>
     * <p>Method searches a substring included 'items'</p>
     * @param json response from the site
     * @return JSON included only element from items
     */
    private String GetItemsJson(String json){
        Integer startIndex = json.indexOf("\"items\":[") + 9;

        if (startIndex == 0){
            return "{}";
        }

        Integer endIndex = json.lastIndexOf("]");
        String result = json.substring(startIndex, endIndex);
        return "[" + result + "]";
    }

    /**
     * <p>Hack: deserialize using generic in class Wrapper</p>
     * @param json response from the site
     * @return JSON not included items
     */
    private String RemoveItemsJson(String json){
        Integer startIndex = json.indexOf("\"items\":[");

        if (startIndex == 0){
            return json;
        }

        Integer endIndex = json.lastIndexOf("]") + 1;
        String result = json.substring(0, startIndex) + "\"items\":[]" + json.substring(endIndex);
        return result;
    }

    /**
     * <p>Get type class Wrapper<T>, where T for example Question</></p>
     * @return Type for serialization
     */
    protected abstract JavaType getTypeWrapper();

    /**
     * <p>Get type class TypeReference<Collection<T>>, where t for example Question</p>
     * @return Type for serialization
     */
    protected abstract TypeReference getTypeGenericClass();

    /**
     * Validate required parameter of request
     * @param value Value
     * @param paramName ParamName
     */
    protected void ValidateString(String value, String paramName)
    {
        if (value == null)
            throw new IllegalArgumentException(paramName);

        if (value.isEmpty())
            throw new IllegalArgumentException(paramName + " cannot be empty");
    }
}
