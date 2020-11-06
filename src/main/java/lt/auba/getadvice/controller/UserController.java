package lt.auba.getadvice.controller;

import lt.auba.getadvice.model.Role;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.repository.UserRepository;
import lt.auba.getadvice.service.RoleService;
import lt.auba.getadvice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("usersList")
    public String viewUserList(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";
    }

    @GetMapping("/showUserLoginForm")
    public String showLoginForm(Model model) {
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/showAdminPage")
    public String showAdminPage(Model model){
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "admin";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user){
        userService.saveUserData(user);
//        user.setUserRole(1L);
//        userService.saveUserData(user);
        return "redirect:/";
    }

//    @GetMapping("/usersList")
//    public String getUsers(Model model) {
//        List<User> users = (List<User>) userRepository.findAll();
//        model.addAttribute("users", users);
//        return "index";
//    }

}
