package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 * <p>Model Question from site of http://api.stackexchange.com</p>
 */
public class Question {
    @JsonProperty("accepted_answer_id")
    private Integer acceptedAnswerId;
    @JsonProperty("answer_count")
    private Integer answerCount;
    private Answer[] answers;
    private String body;
    @JsonProperty("bounty_amount")
    private Integer bountyAmount;
    @JsonProperty("bounty_closes_date")
    private Date bountyClosesDate;
    @JsonProperty("close_vote_count")
    private Integer closeVoteCount;
    @JsonProperty("closed_date")
    private Date closedDate;
    @JsonProperty("closed_reason")
    private String closedReason;
    private Comment[] comments;
    @JsonProperty("community_owned_date")
    private Date communityOwnedDate;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("delete_vote_count")
    private Integer deleteVoteCount;
    @JsonProperty("down_vote_count")
    private Integer downVoteCount;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("is_answered")
    private Boolean isAnswered;
    @JsonProperty("last_activity_date")
    private Date lastActivityDate;
    @JsonProperty("last_edit_date")
    private Date lastEditDate;
    private String link;
    @JsonProperty("locked_date")
    private Date lockedDate;
    @JsonProperty("migrated_from")
    private MigrationInfo migratedFrom;
    @JsonProperty("migrated_to")
    private MigrationInfo migratedTo;
    private Notice notice;
    private ShallowUser owner;
    @JsonProperty("protected_date")
    private Date protectedDate;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("reopen_vote_count")
    private Integer reopenVoteCount;
    private Integer score;
    private String[] tags;
    private String title;
    @JsonProperty("up_vote_count")
    private Integer upVoteCount;
    @JsonProperty("view_count")
    private Integer viewCount;

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(Integer bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public Date getBountyClosesDate() {
        return bountyClosesDate;
    }

    public void setBountyClosesDate(Date bountyClosesDate) {
        this.bountyClosesDate = bountyClosesDate;
    }

    public Integer getCloseVoteCount() {
        return closeVoteCount;
    }

    public void setCloseVoteCount(Integer closeVoteCount) {
        this.closeVoteCount = closeVoteCount;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public Date getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(Date communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getDeleteVoteCount() {
        return deleteVoteCount;
    }

    public void setDeleteVoteCount(Integer deleteVoteCount) {
        this.deleteVoteCount = deleteVoteCount;
    }

    public Integer getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(Integer downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public MigrationInfo getMigratedFrom() {
        return migratedFrom;
    }

    public void setMigratedFrom(MigrationInfo migratedFrom) {
        this.migratedFrom = migratedFrom;
    }

    public MigrationInfo getMigratedTo() {
        return migratedTo;
    }

    public void setMigratedTo(MigrationInfo migratedTo) {
        this.migratedTo = migratedTo;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public ShallowUser getOwner() {
        return owner;
    }

    public void setOwner(ShallowUser owner) {
        this.owner = owner;
    }

    public Date getProtectedDate() {
        return protectedDate;
    }

    public void setProtectedDate(Date protectedDate) {
        this.protectedDate = protectedDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getReopenVoteCount() {
        return reopenVoteCount;
    }

    public void setReopenVoteCount(Integer reopenVoteCount) {
        this.reopenVoteCount = reopenVoteCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(Integer upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
}
