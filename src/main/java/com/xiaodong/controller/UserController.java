package com.xiaodong.controller;

import com.xiaodong.po.User;
import com.xiaodong.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@CrossOrigin (origins = "*")
@Controller
public class UserController {

    @Autowired
    private userService myUserService;

    @RequestMapping("/data")
    public @ResponseBody ResponseEntity<User> getUser() {
        User myUser =myUserService.getUserById(10);
        System.out.println("example data ");
        return new ResponseEntity<User>(myUser, HttpStatus.OK);
    }

    @RequestMapping("/user")
    public @ResponseBody ResponseEntity<List<User>> getAllUser() {
        List<User> myUser =myUserService.listUser();
        System.out.println("List all Users");
        return new ResponseEntity<List<User>>(myUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<User> getUserById(@PathVariable("user_id") int user_id){
        User myUser = myUserService.getUserById(user_id);
        return new ResponseEntity<User>(myUser, HttpStatus.OK);

    }


    @RequestMapping(value = "/user",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<User> postUser(@RequestBody User req){

        System.out.println("POST request: " + req.getUsername());
        myUserService.addUser(req);
        return new ResponseEntity<User>(req, HttpStatus.OK);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT,produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<User>  putUser(@RequestBody User req){
        System.out.println("PUT request: "+req.getUsername());
        myUserService.updateUser(req);
        return new ResponseEntity<User>(req,HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id}",method = RequestMethod.DELETE)
    public @ResponseBody String  deleteUserById(@PathVariable("user_id") int user_id){
        User myUser = myUserService.getUserById(user_id);
        String username = myUser.getUsername();
        int id = myUser.getId();
        myUserService.deleteUser(myUser);
        return "User: "+ username + "("+ id + ")"+" has been delete";

    }

}
