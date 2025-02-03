package org.webapp.savvy.controller;

import org.webapp.savvy.DTO.UserRegistrationDto;
import org.webapp.savvy.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userDto, Model model) {
        boolean registered = userService.registerUser(userDto);

        if (registered) {
            model.addAttribute("success", "Registration successful! You can now login.");
            return "register";
        } else {
            model.addAttribute("error", "Username or email already taken.");
            return "register";
        }
    }
}