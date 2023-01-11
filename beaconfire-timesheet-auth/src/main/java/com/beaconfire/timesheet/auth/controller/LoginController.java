package com.beaconfire.timesheet.auth.controller;

import com.beaconfire.timesheet.auth.dao.User;
import com.beaconfire.timesheet.auth.security.JwtUtils;
import com.beaconfire.timesheet.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginController {
    private UserService userService;
    private JwtUtils jwtUtils;

    @Autowired
    public LoginController(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }
    @RequestMapping(method = RequestMethod.POST)
    public String tst() {
        return "!!!!!!!!";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/getToken", consumes = "application/json")
    public HashMap<String, String> login(@RequestBody HashMap<String, String> user) {
        User currentUser = userService.gerUserByUsername(user.get("username"));
        if (currentUser != null && currentUser.getPassword().equals(user.get("password"))) {
            HashMap<String, String> response = new HashMap<>();
            String token = jwtUtils.generateToken(user.get("username"));
            response.put("token", token);
            Integer userId = currentUser.getId();
            response.put("userId", userId.toString());
            return response;
        }
        HashMap<String, String> response = new HashMap<>();
        response.put("msg", "Failed!");
        return response;
    }
}
