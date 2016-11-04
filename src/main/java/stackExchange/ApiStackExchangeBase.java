package stackExchange;

import org.codehaus.jackson.type.JavaType;
import org.springframework.expression.spel.support.ReflectionHelper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.context.request.WebRequest;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.activation.Activator;
import java.time.LocalDateTime;
import java.util.*;
import java.util.zip.GZIPInputStream;
import org.codehaus.jackson.map.ObjectMapper;
import webapp.model.HttpMethod;
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

    public ApiStackExchangeBase(String version){
        this.version = version;
        apiTimeoutMs = 5000;
        maxSimultaneousRequests = 10;
        respectBackoffs = true;
        objectMapper = new ObjectMapper();
    }

    protected StackExchangeResponse<Wrapper<T>> GetResponse(ApiUrlBuilder urlBuilder, HttpMethod httpMethod, String backOfKey) throws IOException {
        StackExchangeResponse response = new StackExchangeResponse<Wrapper<T>>();
        try
        {

            if (httpMethod == HttpMethod.POST){
                response.setApiUrl(urlBuilder.getBaseUrl());
                response.setRawData(fetchResponseWithPost(response.getApiUrl(), urlBuilder.QueryString()));
            }
            else {
                response.setApiUrl(urlBuilder.toString());
                response.setRawData(fetchResponseWithGet(response.getApiUrl()));
                response.setData(objectMapper.readValue(response.getRawData(), getType()));
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

    protected abstract JavaType getType();

    protected void ValidateString(String value, String paramName)
    {
        if (value == null)
            throw new IllegalArgumentException(paramName);

        if (value == "")
            throw new IllegalArgumentException(paramName + " cannot be empty");
    }

    protected String fetchResponseWithGet(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("Accept-Encoding", "gzip");

        BufferedReader reader = null;

        if ("gzip".equals(request.getContentEncoding())){
            reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(request.getInputStream())));
        }
        else{
            InputStream inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    protected String fetchResponseWithPost(String apiUrl, String urlParameters) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestMethod("POST");
        request.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        request.setRequestProperty("Content-Type", Integer.toString(urlParameters.getBytes().length));

        DataOutputStream outputStream = new DataOutputStream(request.getOutputStream());
        outputStream.writeBytes(urlParameters);
        outputStream.close();

        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
