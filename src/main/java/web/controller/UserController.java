package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.DaoUser;
import web.entity.User;
import web.service.UserServices;
import web.service.UserServicesImp;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller

public class UserController {
    private final DaoUser daoUser;
    @PersistenceContext
    private EntityManager entityManager;

    private final UserServicesImp userServicesImp;

    public UserController(UserServicesImp userServicesImp, DaoUser daoUser) {
        this.userServicesImp = userServicesImp;
        this.daoUser = daoUser;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }
    @GetMapping(value = "/user")
    public String printCars(@RequestParam(value = "count" , defaultValue = "10") int count, ModelMap model ) {
        model.addAttribute("user", userServicesImp.from(count));
        return "index";
    }

    @GetMapping("/new")
    public String createUser(Model model) {
        model.addAttribute("user",new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("name") String name,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("age") int age,
                         @RequestParam("address") String address,
                         Model model) {

//        user.setName(name);
//        user.setLastName(lastName);
//        user.setAge(age);
//        user.setAddress(address);
        daoUser.save(user);
//
//
//        //entityManager.createQuery()
//        model.addAttribute("user",user);
        return "redirect:/user";
    }

}