package lt.auba.getadvice.controller;

import lt.auba.getadvice.model.Post;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.service.PostService;
import lt.auba.getadvice.service.UserService;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Date;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


//    @GetMapping("/newPostForm")
//    public String newPostForm(Model model) {
//        Post post = new Post();
//        model.addAttribute("post", post);
//        return "create_post";
//    }

//    @GetMapping("/newPostForm/{id}")
//    public String newPostForm(@PathVariable(value = "id") long id, Model model) {
//
////        User user = userService.getUserById(id);
////        Long userId = user.getUserId();
//
//        Post post = new Post();
//        //User user = userService.
//        model.addAttribute("userId", id);
//        model.addAttribute("post", post);
//        return "create_post";
//    }

    @GetMapping("/newPostForm/{userId}")
    public String newPostForm2(@PathVariable Long userId, Model model) {
        Post post = new Post();
        post.setUserId(userId);
        model.addAttribute("post", post);
        return "create_post";
    }

    @GetMapping("/getAllPosts")
    public String getAllPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts";
    }

    @PostMapping("/saveNewPost")
    public String saveNewPost(@ModelAttribute(value="post") Post post){
        User user = new User();
        user.setUserId(post.getUserId());
        post.setUserPost(user);
        postService.saveNewPost(post);
        return "redirect:/";
    }


}
