package com.example.springboothelloworld;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.springboothelloworld.servlet.HelloFilter;


public class SpringBootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloworldApplication.class, args);
    }

    //@ServletComponentScan

    @Bean

    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean();
        servletBean.addUrlMappings("/helloServlet");
        return servletBean;
    }

    //Register Filter
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filterBean = new FilterRegistrationBean();
        //Add Filter path
        filterBean.addUrlPatterns("./helloServlet");
        return filterBean;
    }

    @Bean
    public ServletListenerRegistrationBean<HelloListener> getServletRegistrationBean() {
        ServletListenerRegistrationBean listenerBean = new ServletListenerRegistrationBean(new HelloListener());
        return listenerBean;
    }

}
