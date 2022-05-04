package com.example.ebshop.config.exception;

import com.example.ebshop.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class CreateBean {

    @Bean(name = "demo")
    @Primary
    public Book Book(){
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        return new Book("abc");
    }
    @Bean(name = "demo2")
    @Primary
    public Book Book1(){
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        return new Book("ccc");
    }
}
