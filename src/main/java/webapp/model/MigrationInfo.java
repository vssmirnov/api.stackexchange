package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class MigrationInfo {
    @JsonProperty("on_date")
    private Date onDate;
    @JsonProperty("other_site")
    private Site otherSite;
    @JsonProperty("question_id")
    private Integer questionId;

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public Site getOtherSite() {
        return otherSite;
    }

    public void setOtherSite(Site otherSite) {
        this.otherSite = otherSite;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
