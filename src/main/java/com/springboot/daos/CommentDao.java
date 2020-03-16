package com.springboot.daos;


import com.springboot.models.Comment;

import java.util.List;

public interface CommentDao {

    public void writeComment(Comment c);


    public List<Comment> getAllComment();
//    public Comment getByEmailId(String emailId);
    public Comment getById(int id);

}
