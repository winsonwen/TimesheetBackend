package com.beaconfire.timesheet.auth.service;

import com.beaconfire.timesheet.auth.dao.User;
import com.beaconfire.timesheet.auth.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDAO userDAO;
    @Autowired
    public void setUserDAO(UserDAO userDAO) {this.userDAO = userDAO;}

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }
    @Transactional
    public User gerUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
