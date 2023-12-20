package com.becoder.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.model.UserDtls;
import com.becoder.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    // @ModelAttribute is a method-level annotation that binds a method parameter or
    // method return value to a named model attribute, exposed to the web view

    @ModelAttribute
    private void userDetails(Model model, Principal principal) {
        String email = principal.getName();
        UserDtls user = userRepo.findByEmail(email);

        model.addAttribute("user", user);
    }

    @GetMapping("/")
    public String home() {
        return "user/home";
    }
}
