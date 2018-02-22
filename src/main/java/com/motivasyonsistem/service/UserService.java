package com.motivasyonsistem.service;

import com.motivasyonsistem.domain.User;

/**
 * Created by burcu on 22.02.2018.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findByMail(String mail);
    

}
