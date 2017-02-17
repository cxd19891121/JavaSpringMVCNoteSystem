package com.xiaodong.dao;

import com.xiaodong.po.User;
import java.util.List;
/**
 * Created by xiaodong chen on 2/16/2017.
 */



public interface IUserDao {

    void addUser(User user);

    User getUserById(int id);

    List<User> findAllUser();

    void updateUser(User cat);

    void deleteUser(User user);

}
