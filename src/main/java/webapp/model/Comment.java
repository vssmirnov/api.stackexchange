package webapp.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * Created by vssmirnov on 02.11.2016.
 */
public class Comment {
    private String body;
    @JsonProperty("body_markdown")
    private String bodyMarkdown;
    @JsonProperty("comment_id")
    private Integer commentId;
    @JsonProperty("creation_date")
    private Date creationDate;
    private Boolean edited;
    private String link;
    private ShallowUser owner;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("post_type")
    private PostType postType;
    @JsonProperty("reply_to_user")
    private ShallowUser replyToUser;
    private Integer score;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyMarkdown() {
        return bodyMarkdown;
    }

    public void setBodyMarkdown(String bodyMarkdown) {
        this.bodyMarkdown = bodyMarkdown;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ShallowUser getOwner() {
        return owner;
    }

    public void setOwner(ShallowUser owner) {
        this.owner = owner;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public ShallowUser getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(ShallowUser replyToUser) {
        this.replyToUser = replyToUser;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
