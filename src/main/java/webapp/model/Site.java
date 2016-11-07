package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model Site from site of http://api.stackexchange.com</p>
 */
public class Site {
    private String[] aliases;
    @JsonProperty("api_site_parameter")
    private String apiSiteParameter;
    private String audience;
    @JsonProperty("closed_beta_date")
    private Date closedBetaDate;
    @JsonProperty("favicon_url")
    private String faviconUrl;
    @JsonProperty("high_resolution_icon_url")
    private String highResolutionIconUrl;
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("launch_date")
    private Date launchDate;
    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("markdown_extensions")
    private String[] markdownExtensions;
    private String name;
    @JsonProperty("open_beta_date")
    private Date openBetaDate;
    @JsonProperty("related_sites")
    private RelatedSite[] relatedSites;
    @JsonProperty("site_state")
    private SiteState siteState;
    @JsonProperty("site_type")
    private String siteType;
    @JsonProperty("site_url")
    private String siteUrl;
    private Styling styling;
    @JsonProperty("twitter_account")
    private String twitterAccount;

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Date getClosedBetaDate() {
        return closedBetaDate;
    }

    public void setClosedBetaDate(Date closedBetaDate) {
        this.closedBetaDate = closedBetaDate;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getHighResolutionIconUrl() {
        return highResolutionIconUrl;
    }

    public void setHighResolutionIconUrl(String highResolutionIconUrl) {
        this.highResolutionIconUrl = highResolutionIconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String[] getMarkdownExtensions() {
        return markdownExtensions;
    }

    public void setMarkdownExtensions(String[] markdownExtensions) {
        this.markdownExtensions = markdownExtensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpenBetaDate() {
        return openBetaDate;
    }

    public void setOpenBetaDate(Date openBetaDate) {
        this.openBetaDate = openBetaDate;
    }

    public RelatedSite[] getRelatedSites() {
        return relatedSites;
    }

    public void setRelatedSites(RelatedSite[] relatedSites) {
        this.relatedSites = relatedSites;
    }

    public SiteState getSiteState() {
        return siteState;
    }

    public void setSiteState(SiteState siteState) {
        this.siteState = siteState;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Styling getStyling() {
        return styling;
    }

    public void setStyling(Styling styling) {
        this.styling = styling;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
}
