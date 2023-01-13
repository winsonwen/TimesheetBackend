package com.beaconfire.timesheet.auth.dao.impl;

import com.beaconfire.timesheet.auth.dao.AbstractHibernateDAO;
import com.beaconfire.timesheet.auth.dao.User;
import com.beaconfire.timesheet.auth.dao.UserDAO;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl extends AbstractHibernateDAO<User> implements UserDAO {
    public UserDAOImpl() {
        setClazz(User.class);
    }
    @Override
    public User getUserById(Integer id) {
        return findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = getCurrentSession().createQuery("from User where email = :username");
        query.setParameter("username", username);
        List<User> result = query.getResultList();
        if (result.size() == 0) return null;
        return result.get(0);
    }
}
