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
 */
public abstract class ApiStackExchangeBase<T> {
    private final int apiTimeoutMs;
    private final int maxSimultaneousRequests;
    private final boolean respectBackoffs;
    protected final ObjectMapper objectMapper;
    protected String version;
    private IHTTPMethodRequest httpMethodRequest;

    public ApiStackExchangeBase(String version, IHTTPMethodRequest httpMethodRequest){
        this.version = version;
        this.httpMethodRequest = httpMethodRequest;
        apiTimeoutMs = 5000;
        maxSimultaneousRequests = 10;
        respectBackoffs = true;
        objectMapper = new ObjectMapper();
    }

    protected StackExchangeResponse<T> GetResponse(ApiUrlBuilder urlBuilder, HttpMethod httpMethod, String backOfKey) throws IOException {
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
                TypeFactory factory = TypeFactory.defaultInstance();
                objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                ArrayList<Question> list = objectMapper.readValue(itemsJson, new TypeReference<Collection<Question>>(){} /*factory.constructCollectionType(ArrayList.class, Question.class)*/);
                String wrapperJson = RemoveItemsJson(response.getRawData());
                Wrapper wrapper = objectMapper.readValue(wrapperJson, getTypeWrapper());
                wrapper.setItems(list.toArray());

                response.setWrapper(wrapper);
            }
        }
        catch (Exception ex){
            throw ex;
        }
        finally
        {
            return response;
        }
    }

    private String GetItemsJson(String json){
        Integer startIndex = json.indexOf("\"items\":[") + 9;

        if (startIndex == 0){
            return "{}";
        }

        Integer endIndex = json.lastIndexOf("]");
        String result = json.substring(startIndex, endIndex);
        return "[" + result + "]";
    }

    private String RemoveItemsJson(String json){
        Integer startIndex = json.indexOf("\"items\":[");

        if (startIndex == 0){
            return json;
        }

        Integer endIndex = json.lastIndexOf("]") + 1;
        String result = json.substring(0, startIndex) + "\"items\":[]" + json.substring(endIndex);
        return result;
    }

    protected abstract JavaType getTypeWrapper();
    protected abstract JavaType getTypeGenericClass();

    protected void ValidateString(String value, String paramName)
    {
        if (value == null)
            throw new IllegalArgumentException(paramName);

        if (value == "")
            throw new IllegalArgumentException(paramName + " cannot be empty");
    }
}
