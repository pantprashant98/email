package com.springboot.repos;

import com.springboot.models.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User,String> {

    User findByEmailIdIgnoreCase(String emailId);
//    User findByNameAndPassword(String n,String psw);
}
