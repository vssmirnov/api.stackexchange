package stackExchange;

import webapp.model.Wrapper;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Wrapper for response site of api.stackexchange</p>
 */
public class StackExchangeResponse<T> {
    private boolean succes;
    private Wrapper<T> wrapper;
    private Exception error;
    private String apiUrl;
    private String rawData;

    /**
     * <p>The response is received</p>
     * @return true is good, false is bad and see error
     */
    public boolean isSucces() {
        return succes;
    }

    /**
     * Set the response status
     * @param succes true is good, false is bad
     */
    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    /**
     * Get Wrapper
     * @return Wrapper<T>, where T for example Question
     */
    public Wrapper<T> getWrapper() {
        return wrapper;
    }

    /**
     * Wrapper
     * @param wrapper Wrapper
     */
    public void setWrapper(Wrapper<T> wrapper) {
        this.wrapper = wrapper;
    }

    /**
     * Get error receiving data
     * @return Any exception
     */
    public Exception getError() {
        return error;
    }

    /**
     * Set error receiving data
     * @param error Any exception
     */
    public void setError(Exception error) {
        this.error = error;
    }

    /**
     * Get full address url, for example http://api.stackexchange.com/2.2/search?site=stackoverflow.com&pagesize=1&intitle=Test
     * @return Address url
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * Set full address url, for example http://api.stackexchange.com/2.2/search?site=stackoverflow.com&pagesize=1&intitle=Test
     * @param apiUrl Address url
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * Get JSON data
     * @return JSON data in string
     */
    public String getRawData() {
        return rawData;
    }

    /**
     * Set JSON data
     * @param rawData JSON data in string
     */
    public void setRawData(String rawData) {
        this.rawData = rawData;
    }
}
