package stackExchange;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by Drol on 04.11.2016.
 */
public class HTTPMethodRequest implements IHTTPMethodRequest {
    @Override
    public String fetchResponseWithGet(String apiUrl) throws IOException {
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

    @Override
    public String fetchResponseWithPost(String apiUrl, String urlParameters) throws IOException {
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
