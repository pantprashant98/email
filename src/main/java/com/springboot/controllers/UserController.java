package com.springboot.controllers;

import com.springboot.models.ConformationToken;
import com.springboot.models.User;
import com.springboot.repos.ConformationTokenRepos;
import com.springboot.repos.UserRepos;
import com.springboot.service.EmailSenderService;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private ConformationTokenRepos conformationTokenRepos;

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, User user)
    {
        logger.info("Register Page of");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerForm");
        return modelAndView;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, User user) throws MessagingException, IOException, TemplateException {


        User existingUser = userRepos.findByEmailIdIgnoreCase(user.getEmailId());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("errorMessage");
        }
        else
        {

            userRepos.save(user);

            ConformationToken conformationToken = new ConformationToken(user);
            conformationTokenRepos.save(conformationToken);

            Configuration configuration = new Configuration(new Version(2,3,28));

            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper mailMessage = new MimeMessageHelper(message,true);

            Map<String, Object> model = new HashMap<>();
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

            Template template = configuration.getTemplate("email-template.ftl");
            String  html =FreeMarkerTemplateUtils.processTemplateIntoString(template,model);

            configuration.setClassForTemplateLoading(UserController.class, "src/main/resources/templates");
            mailMessage.setTo(user.getEmailId());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("pprasan724@gmail.com");
            mailMessage.setText("<h1>To confirm your account, please click here </h1><br>:"
                    +"http://localhost:8080/confirm-account?token="+conformationToken.getConformationToken(),true );

            emailSenderService.sendEmail(message);
           // emailSenderService.sendEmail(mailMessage);
            modelAndView.addObject("emailId", user.getEmailId());
            modelAndView.setViewName("successfulRegisteration");

        }

        return modelAndView;
    }



    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String conformationToken)
    {
        ConformationToken token = conformationTokenRepos.findByConformationToken(conformationToken);

        if(token != null)
        {
            User user = userRepos.findByEmailIdIgnoreCase(token.getUser().getEmailId());
            user.setEnabled(true);
            userRepos.save(user);
            modelAndView.setViewName("accountVerified");

        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("errorMessage");

        }

        return modelAndView;
    }





}


