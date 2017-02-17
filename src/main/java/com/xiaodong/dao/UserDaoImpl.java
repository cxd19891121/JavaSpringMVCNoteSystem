package com.xiaodong.dao;

import com.xiaodong.hibernate.dbDriver;
import com.xiaodong.po.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@Repository
public class UserDaoImpl implements IUserDao{

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void initialSessionFactory(){

        this.sessionFactory = dbDriver.getSessionFactory();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();

    }

    public void addUser(User user) {
        initialSessionFactory();
        session.save(user);
        transaction.commit();
    }

    public User getUserById(int id) {
        initialSessionFactory();
        User findUser = (User) session.get(User.class, new Integer(id));
        transaction.commit();
        return findUser;
    }

    public List<User> findAllUser() {
        initialSessionFactory();

        List<User> userList = session.createQuery("from  com.xiaodong.po.User").list();
        for(User user : userList){
            System.out.println("Person List::"+user);
        }
        transaction.commit();
        return userList;

    }

    public void updateUser(User user) {
        initialSessionFactory();
        session.update(user);
        transaction.commit();
    }


    public void deleteUser(User user) {
        initialSessionFactory();
        session.delete(user);
        transaction.commit();
    }
}
