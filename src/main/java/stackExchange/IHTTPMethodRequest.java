package stackExchange;

import java.io.IOException;

/**
 * Created by Drol on 04.11.2016.
 * <p>Interface HTTP methods GET and POST</p>
 */
public interface IHTTPMethodRequest {
    /**
     * <p>HTTP method GET</p>
     * @param apiUrl Url adress
     * @return JSON
     * @throws IOException Any exception
     */
    String fetchResponseWithGet(String apiUrl) throws IOException;

    /**
     * <p>HTTP method POST</p>
     * @param apiUrl Url adress
     * @param urlParameters Paramters
     * @return JSON
     * @throws IOException Any exception
     */
    String fetchResponseWithPost(String apiUrl, String urlParameters) throws IOException;
}
