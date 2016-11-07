package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model RelatedSite from site of http://api.stackexchange.com</p>
 */
public class RelatedSite {
    @JsonProperty("api_site_parameter")
    private String apiSiteParameter;
    private String name;
    private String relation;
    @JsonProperty("site_url")
    private String siteUrl;

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
}
