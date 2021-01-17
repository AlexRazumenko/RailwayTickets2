package org.alex.railway.tickets.controller;


import lombok.extern.slf4j.Slf4j;
import org.alex.railway.tickets.dto.UserDTO;
import org.alex.railway.tickets.entity.User;

import org.alex.railway.tickets.entity.enums.RoleType;
import org.alex.railway.tickets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@SessionAttributes(value = "currentUser")
//@RequestMapping(value = "/")
public class LoginController {

    @ModelAttribute("currentUser")
    public User createUser() {
        return new User(0L);
    }

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage(@ModelAttribute("currentUser") User currentUser, @ModelAttribute("logUserDTO") UserDTO logUserDTO) {
        if (currentUser.getId() == 0) {
            logUserDTO = new UserDTO();
            return "login";
        }
//        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("currentUser", user);

        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("logUserDTO") UserDTO userDTO, @ModelAttribute("currentUser") User currentUser) {
        currentUser = userService.findByLogin(userDTO);
        return "index";
    }

@GetMapping("/register")
    public String redirectToRegisterPage(@ModelAttribute("currentUser") User user) {
        return "register";
    }


    @PostMapping("/register")
    public String register (@ModelAttribute("currentUser") User currentUser) {
        currentUser.setRole(RoleType.ROLE_USER);
        userService.save(currentUser);
        return "index";
    }

//userService.save(user);


//    public String loginPage


}
