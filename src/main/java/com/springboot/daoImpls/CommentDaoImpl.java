package com.springboot.daoImpls;

import com.springboot.daos.CommentDao;
import com.springboot.models.Comment;
import com.springboot.models.User;
import com.springboot.repos.CommentRepos;
import com.springboot.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private CommentRepos commentRepos;
    @Autowired
    private UserRepos userRepos;

    @Override
    @Transactional
    public void writeComment(Comment c) {
            Comment comment = new Comment();
            Date date = new Date();
            c.setDate(date);
            commentRepos.save(comment);
        }


    private List<Comment> getComment(List<Comment> com) {

        List<Comment> commentList = new ArrayList<>();
        for
                (Comment c : com)

        {
            commentList.add(c);
        }
        return commentList;
    }

    @Override
    @Transactional
    public List<Comment> getAllComment() {
        return getComment(commentRepos.findAll());
    }



    @Override
    @Transactional
    public Comment getById(int id) {

        return commentRepos.findOne(id);
    }


}



