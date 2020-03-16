package com.springboot.daoImpls;

import com.springboot.daos.LoginDao;
import com.springboot.models.User;
import com.springboot.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDaoImpl implements LoginDao {

//    @Autowired
//    private UserRepos userRepos;
//
//    @Override
//    @Transactional
//    public boolean login(String n, String psw) {
//        User user = userRepos.findByNameAndPassword(n,psw);
//        return user != null;
//
//    }
}
