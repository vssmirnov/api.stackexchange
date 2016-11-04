package stackExchange;

import java.io.IOException;

/**
 * Created by Drol on 04.11.2016.
 */
public interface IHTTPMethodRequest {
    String fetchResponseWithGet(String apiUrl) throws IOException;
    String fetchResponseWithPost(String apiUrl, String urlParameters) throws IOException;
}
