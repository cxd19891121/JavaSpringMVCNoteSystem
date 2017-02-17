package com.xiaodong.service;

import com.xiaodong.po.User;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */
public interface userService {

    void addUser(User user);
    void updateUser(User user);
    List<User> listUser();
    User getUserById(int id);
    void deleteUser(User user);
}
