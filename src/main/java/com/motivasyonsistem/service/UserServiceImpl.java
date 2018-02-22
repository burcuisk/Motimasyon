package com.motivasyonsistem.service;

import com.motivasyonsistem.dao.UserDao;
import com.motivasyonsistem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by burcu on 22.02.2018.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public void save(User user) {
        userdao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userdao.findByUsername(username);
    }

    @Override
    public User findByMail(String mail) {return userdao.findByEmail(mail); }


}
