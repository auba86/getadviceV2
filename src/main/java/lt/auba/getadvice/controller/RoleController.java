package lt.auba.getadvice.controller;

import lt.auba.getadvice.model.Role;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/createRole")
    public String createRole(Model model) {
        Role role = new Role();
        model.addAttribute("role", role);
        return "admin";
    }
}
