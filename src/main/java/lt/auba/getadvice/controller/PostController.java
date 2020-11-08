package lt.auba.getadvice.controller;

import lt.auba.getadvice.model.Post;
import lt.auba.getadvice.model.Rating;
import lt.auba.getadvice.model.Role;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.service.PostService;
import lt.auba.getadvice.service.RatingService;
import lt.auba.getadvice.service.UserService;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/getAllPosts")
    public String viewPostList(Model model) {
        List<Post> postList = postService.getAllPosts();
        model.addAttribute("postsList", postList);
        return "posts";
    }

    @GetMapping("/newPostForm/{userId}")
    public String newPostForm(@PathVariable Long userId, Model model) {
        Post post = new Post();
        post.setUserId(userId);
        model.addAttribute("post", post);
        return "create_post";
    }

    @PostMapping("/saveNewPost")
    public String saveNewPost(@ModelAttribute(value="post") Post post){
        User user = new User();
        user.setUserId(post.getUserId());
        post.setUser(user);

        Rating rating = new Rating();
        rating.setRatingValue(0);
        ratingService.saveRating(rating);

        post.setRating(rating);

        postService.saveNewPost(post);
        return "index";
    }

}
