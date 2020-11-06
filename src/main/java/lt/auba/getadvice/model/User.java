package lt.auba.getadvice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String fullName;

    private String nickName;

    private String password;

    private String email;

    @OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Post> userPost;

    @OneToMany(mappedBy = "userComment", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Comment> userComment;

    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "roleId")
    private Role userRole;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(Set<Post> userPost) {
        this.userPost = userPost;
    }

    public Set<Comment> getUserComment() {
        return userComment;
    }

    public void setUserComment(Set<Comment> userComment) {
        this.userComment = userComment;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
