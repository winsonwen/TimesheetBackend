package com.beaconfire.timesheet.auth.dao;

import java.util.List;

public interface UserDAO {
    User getUserById(Integer id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    User getUserByUsername(String username);
}
