package codegym.vn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Comment {

    @Id
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "comment_author", columnDefinition = "varchar(50)")
    private String commentAuthor;
    @Column(name = "comment_content", columnDefinition = "varchar(255)")
    private String commentContent;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    public Comment() {
    }

    public Comment(int commentId, String commentAuthor, String commentContent, Blog blog) {
        this.commentId = commentId;
        this.commentAuthor = commentAuthor;
        this.commentContent = commentContent;
        this.blog = blog;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
