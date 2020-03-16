package com.springboot.controllers;

import com.springboot.daos.CommentDao;
import com.springboot.daos.LoginDao;
import com.springboot.daos.UserDao;
import com.springboot.models.Comment;
import com.springboot.models.User;
import com.springboot.repos.UserRepos;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;



    @GetMapping("/login")
    public String displayLogin(User user,Model model)
    {
        model.addAttribute("user",user);
        return "login";
    }


//    @PostMapping("/login")
//    public ModelAndView loginUser(ModelAndView modelAndView, User user) {
//
//        if(userDao.login(user.getName(),user.getPassword())){
//            modelAndView.addObject("user", user);
//            modelAndView.addObject("commentList", commentDao.getAllComment());
//            modelAndView.setViewName("list");
//        }
//
//        modelAndView.addObject("errors","User Does Not exists");
//        modelAndView.setViewName("login");
//
//        return modelAndView;
//
//    }

    @PostMapping("/login")
public String loginUser(@ModelAttribute("user")User user,Model model){
        if(userDao.login(user.getName(),user.getPassword())){

            model.addAttribute("userName",user.getName());
            model.addAttribute("commentList",commentDao.getAllComment());
            return "list";
        }
        model.addAttribute("errors","User Does nt exists!!");


        return "login";
}




}




