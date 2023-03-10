package com.springboot2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springboot2.model.User;
import com.springboot2.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String getUser(Model model) {
        model.addAttribute("userList", userService.getList());
        return "user";
    }

    @GetMapping("/newAddUser")
    public String addNewUser(Model model) {
        model.addAttribute("user",new User());
        return "user_add";
    }

    @PostMapping
    public String saveNewUser (@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }
    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @GetMapping("/editUser/{id}")
    public String editUser (Model model, @PathVariable("id") long id) {

        model.addAttribute("user", userService.getUser(id));
        return "user_edit";
    }
    @PatchMapping("{id}")
    public String userSaveEdit (@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

}
