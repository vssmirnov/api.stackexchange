package stackExchange;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * Created by Drol on 04.11.2016.
 * <p>Implemetation IHTTPMethodRequest</p>
 */
public class HTTPMethodRequest implements IHTTPMethodRequest {

    /**
     * <p>HTTP method GET</p>
     * @param apiUrl Url adress
     * @return JSON
     * @throws IOException Any exception
     */
    @Override
    public String fetchResponseWithGet(String apiUrl) throws IOException {
        StringBuilder response;
        HttpURLConnection request;
        URL url = new URL(apiUrl);
        request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.setRequestProperty("Accept-Encoding", "gzip");

        try(InputStreamReader inputStreamReader = new InputStreamReader(new GZIPInputStream(request.getInputStream())))
        {
            try(BufferedReader reader = new BufferedReader(inputStreamReader)){
                response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                return response.toString();
            }
        }
    }

    /**
     * <p>HTTP method POST</p>
     * <p>Not tested</p>
     * @param apiUrl Url adress
     * @param urlParameters Paramters
     * @return JSON
     * @throws IOException Any exception
     */
    @Override
    public String fetchResponseWithPost(String apiUrl, String urlParameters) throws IOException {
        StringBuilder response;
        BufferedReader reader = null;
        DataOutputStream outputStream = null;
        HttpURLConnection request = null;

        try {
            URL url = new URL(apiUrl);
            request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            request.setRequestProperty("Content-Type", Integer.toString(urlParameters.getBytes().length));

            outputStream = new DataOutputStream(request.getOutputStream());
            outputStream.writeBytes(urlParameters);
        }
        catch (Exception ex) {throw ex;
        }
        finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                }
                catch (IOException ex) {
                    throw ex;
                }
        }

        try{
            reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){response.append(line);
            }
            reader.close();
            return response.toString();
        }catch (Exception ex){
            throw ex;
        }
        finally {
            if (reader != null)
                try{
                    reader.close();
                }
                catch (IOException ex){
                    throw ex;
                }
        }
    }
}
