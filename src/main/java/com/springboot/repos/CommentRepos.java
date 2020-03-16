package com.springboot.repos;

import com.springboot.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepos extends JpaRepository<Comment,Integer> {

//    Comment findByEmailIdIgnoreCase(String emailId);
Comment findOne(int id);

}
