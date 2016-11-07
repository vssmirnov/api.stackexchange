package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model Styling from site of http://api.stackexchange.com</p>
 */
public class Styling {
    @JsonProperty("link_color")
    private String linkColor;
    @JsonProperty("tag_background_color")
    private String tagBackgroundColor;
    @JsonProperty("tag_foreground_color")
    private String tagForegroundColor;

    public String getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

    public String getTagBackgroundColor() {
        return tagBackgroundColor;
    }

    public void setTagBackgroundColor(String tagBackgroundColor) {
        this.tagBackgroundColor = tagBackgroundColor;
    }

    public String getTagForegroundColor() {
        return tagForegroundColor;
    }

    public void setTagForegroundColor(String tagForegroundColor) {
        this.tagForegroundColor = tagForegroundColor;
    }
}
