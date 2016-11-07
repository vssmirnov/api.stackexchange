package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model Wrapper from site of http://api.stackexchange.com</p>
 */
public class Wrapper<T> {
    private Integer backoff;
    @JsonProperty("error_id")
    private Integer errorId;
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("error_name")
    private String errorName;
    @JsonProperty("has_more")
    private Boolean hasMore;
    private T[] items;
    private Integer page;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("quota_max")
    private Integer quotaMax;
    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;
    private Integer total;
    private Integer type;

    public Integer getBackoff() {
        return backoff;
    }

    public void setBackoff(Integer backoff) {
        this.backoff = backoff;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
