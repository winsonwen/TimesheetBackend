package com.beaconfire.timesheet.auth.controller;


import com.beaconfire.timesheet.auth.dao.User;
import com.beaconfire.timesheet.auth.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Getter
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(method = RequestMethod.POST)
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
