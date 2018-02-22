package com.motivasyonsistem.dao;

import com.motivasyonsistem.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by burcu on 22.02.2018.
 */

public interface UserDao extends CrudRepository<User,Long> {

    User findByUsername(String username);
    User save(User user);
    User findByEmail(String mail);
}
