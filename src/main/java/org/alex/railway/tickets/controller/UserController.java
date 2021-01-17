package org.alex.railway.tickets.controller;

import lombok.extern.slf4j.Slf4j;
import org.alex.railway.tickets.dto.UsersDTO;
import org.alex.railway.tickets.entity.User;
import org.alex.railway.tickets.entity.enums.RoleType;
import org.alex.railway.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/")
@SessionAttributes(value = "currentUser")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("currentUser")
    public User createUser() {
        return new User(0L);
    }

    @GetMapping("/viewAllUsers")
    public ModelAndView viewAllUsers(@ModelAttribute("currentUser") User currentUser, @ModelAttribute("allUsers") UsersDTO allUsers) {
        ModelAndView modelAndView = new ModelAndView("allUsers");
        if (currentUser.getRole() != RoleType.ROLE_ADMIN) {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "Access denied.");
            return modelAndView;
        }
        modelAndView.addObject("allUsers", allUsers = userService.getAll());
        return modelAndView;
    }

    @GetMapping("/user/{id}")
    public ModelAndView viewUserPage(@PathVariable("id") Long id, @ModelAttribute("currentUser") User currentUser) {
        ModelAndView modelAndView = new ModelAndView("user");
        if (currentUser.getRole() != RoleType.ROLE_ADMIN || !currentUser.id.equals(id)) {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message", "Access denied.");
            return modelAndView;
        }

        User user = userService.findById(id);
        modelAndView.addObject("user", user);
        if (currentUser.getRole() == RoleType.ROLE_ADMIN)
            modelAndView.addObject("userRoles", RoleType.values());
        return modelAndView;
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id, @ModelAttribute("current User") User currentUser) {
        userService.delete(id);
        return currentUser.getRole() == RoleType.ROLE_ADMIN ? "allUsers" : "index";
    }


}
