package org.zx.springboot0319.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zx.springboot0319.model.User;
import org.zx.springboot0319.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/adduser")
    public User addUser(String username, String password){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userService.addUser(user);
        return user;
    }
    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
}
