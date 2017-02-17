package com.xiaodong.service;

import com.xiaodong.po.User;
import com.xiaodong.dao.IUserDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Created by xiaodong chen on 2/16/2017.
 */

@Service
@Transactional
public class userServiceImpl implements userService {

    @Autowired
    private IUserDao userDao;

    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> listUser() {
        return userDao.findAllUser();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
