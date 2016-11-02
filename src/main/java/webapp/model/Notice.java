package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class Notice {
    private String body;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("owner_user_id")
    private Integer ownerUserId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
    }
}
