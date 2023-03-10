package com.example.PP_3_2_1_Spring_Boot.controller;

import com.example.PP_3_2_1_Spring_Boot.model.User;

import com.example.PP_3_2_1_Spring_Boot.service.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> user = userServiceImp.findAll();
        model.addAttribute("users", user);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.getById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("adduser") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("adduser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "users";
        userServiceImp.saveUser(user);
        return "redirect:users";
    }

    @GetMapping("/edit/{id}")
    public String updateUserFrom(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.getById(id));
        return "update";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "update";
        userServiceImp.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServiceImp.deleteUserById(id);
        return "redirect:users";
    }
}

