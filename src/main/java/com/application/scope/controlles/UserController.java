package com.application.scope.controlles;


import com.application.scope.Interfaces.IUserService;
import com.application.scope.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Inject
    private IUserService userService;

    //mapping the addUser() method to /user
    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user) {
        //creates all the user
      User addedUser =  userService.addUser(user);
      return addedUser;

    }
    //mapping the addUser() method to /user
    @PostMapping(value = "/create-all")
    public List<User> addUsers() {
    //creates all the users
        List<User> users = userService.create();
    //returns the user list
        return users;
    }

    //updating user..
    @PutMapping(value = "/update/{name}")
    public User updateEmp(@RequestBody User user, @PathVariable("name") String userName) {
        User savedUser =  userService.updateUser(userName, user);
        return savedUser;
    }

    @GetMapping(value = "/{name}")
    public User getUserByName(@PathVariable("name") String userName) {
        //finds the user by name
        User user = userService.getUser(userName);
        //returns the user
        return user;
    }

    //mapping the getUser() method to /user
    @GetMapping(value = "/all")
    public List<User> allUsers() {
        //finds all the users
        List<User> users = userService.getUserList();
        //returns the user list
        return users;
    }

  //Deleting particular user from the list
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

}
