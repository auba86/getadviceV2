package lt.auba.getadvice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String description;

//    private Date commentDate;

    @ManyToOne
    @JoinColumn(name="postId", nullable=false)
    @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    @JsonBackReference
    private Comment userComment;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Date getCommentDate() {
//        return commentDate;
//    }
//
//    public void setCommentDate(Date commentDate) {
//        this.commentDate = commentDate;
//    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getUserComment() {
        return userComment;
    }

    public void setUserComment(Comment userComment) {
        this.userComment = userComment;
    }
}
