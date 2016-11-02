package stackExchange;

import webapp.model.Wrapper;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class StackExchangeResponse<T> {
    private boolean succes;
    private Wrapper<T> data;
    private Exception error;
    private String apiUrl;
    private String rawData;

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public Wrapper<T> getData() {
        return data;
    }

    public void setData(Wrapper<T> data) {
        this.data = data;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }
}
