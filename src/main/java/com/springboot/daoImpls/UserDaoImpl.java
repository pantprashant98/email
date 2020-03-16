package com.springboot.daoImpls;

import com.springboot.daos.UserDao;
import com.springboot.dtos.UserDto;
import com.springboot.models.User;
import com.springboot.repos.LoginRepos;
import com.springboot.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private LoginRepos loginRepos;

    @Override
    @Transactional
    public boolean login(String n, String psw) {

        User user = loginRepos.findByNameAndPassword(n,psw);
        return user != null;

        }
    }




