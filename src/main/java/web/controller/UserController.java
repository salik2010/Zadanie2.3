package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserServices;

@Controller
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userServices.getAllUsers());
        return "index";
    }


    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userServices.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userServices.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user =  userServices.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }
    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userServices.edit(user);
        return "redirect:/";
    }
}