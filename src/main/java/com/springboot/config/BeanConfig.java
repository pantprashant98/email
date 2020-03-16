package com.springboot.config;

import freemarker.template.TemplateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.spring3.SpringTemplateEngine;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;

@Configuration
public class BeanConfig {
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Bean
    public SessionFactory getSessionFactory() {
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }




    }

