package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.becoder.model.UserDtls;
import com.becoder.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDtls());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute UserDtls user, RedirectAttributes redirectAttributes) {
        boolean emailExists = userService.checkEmail(user.getEmail());

        if (emailExists) {
            redirectAttributes.addFlashAttribute("error", "Email Id already exists");
        } else {
            UserDtls createdUser = userService.createUser(user);
            if (createdUser != null) {
                redirectAttributes.addFlashAttribute("success", "Registration Successful");
            } else {
                redirectAttributes.addFlashAttribute("error", "Something went wrong on the server");
            }
        }

        return "redirect:/register";
    }
}
