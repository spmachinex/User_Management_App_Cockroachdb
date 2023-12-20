package com.becoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/")
    public String home(Model model) {
        // You can add logic here to fetch and display data specific to the admin user
        // For example, you might fetch admin-related data from Cassandra and pass it to the view
        // model.addAttribute("adminData", adminDataService.getData());

        return "admin/home";
    }
}
