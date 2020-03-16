package com.springboot.controllers;

import com.springboot.daos.CommentDao;
import com.springboot.models.Comment;
import com.springboot.models.User;
import com.springboot.repos.CommentRepos;
import com.springboot.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentRepos commentRepos;

    @Autowired
    private CommentDao commentDao;

    @GetMapping("/comment")
    public String getComment(Model model,Comment comment){

        model.addAttribute("comment",comment);

                return "commentForm";
    }



    @PostMapping("/comment")
    public String comment(@ModelAttribute("comment")Comment comment,User user,Model model){
                  Date date = new Date();
                  comment.setDate(date);
                  commentRepos.save(comment);

        return "login";
    }

}


