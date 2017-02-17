package com.xiaodong.controller;

import com.xiaodong.po.User;
import com.xiaodong.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@Controller
public class HomeController {


    @Autowired
    private userService myUserService;

    @RequestMapping("/")
    public String home(Model model){
        System.out.println("Home page");
        System.out.println("Initial Hibernate");
        model.addAttribute("User", myUserService.getUserById(9));
        return "index";
    }

    @RequestMapping("/hello")
    public String home2(Model model){

        model.addAttribute("User",new User("Test username"));
        return "index";
    }


}
