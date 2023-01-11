package com.beaconfire.timesheet.auth.dao.impl;

import com.beaconfire.timesheet.auth.dao.User;
import com.beaconfire.timesheet.auth.dao.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    private final List<User> userList;
    public UserDAOImpl() {
        userList = new ArrayList<>();
        userList.add(new User(1, "1111", "1111"));
        userList.add(new User(2, "2222", "2222"));
    }
    @Override
    public User getUserById(Integer id) {
        return userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public User getUserByUsername(String username) {
        return userList.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }
}
