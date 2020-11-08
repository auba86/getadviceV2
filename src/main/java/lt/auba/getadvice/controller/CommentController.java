package lt.auba.getadvice.controller;

import javafx.geometry.Pos;
import lt.auba.getadvice.model.Comment;
import lt.auba.getadvice.model.Post;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/addNewComment")
    public String newCommentForm(HttpServletRequest httpServletRequest, Model model) {

        Comment comment = new Comment();
        comment.setPostId(new Long(httpServletRequest.getParameter("postId")));
        comment.setUserId(new Long(httpServletRequest.getParameter("userId")));
        model.addAttribute("comment", comment);
        return "create_comment";
    }

    @PostMapping("/saveNewComment")
    public String saveNewComment(@ModelAttribute(value="comment") Comment comment){

        User user = new User();
        Post post = new Post();

        user.setUserId(comment.getUserId());
        post.setPostId(comment.getPostId());

        comment.setUser(user);
        comment.setPost(post);
        commentService.saveNewComment(comment);
        return "index";
    }
}
