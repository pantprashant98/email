package com.springboot.repos;
import com.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepos  extends JpaRepository<User,Integer> {

    User findByNameAndPassword(String n, String psw);
}
