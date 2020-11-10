package com.shoaib.employeeinformation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/api/salaryGrade").permitAll();
        http.authorizeRequests().antMatchers("/api/bank").permitAll();
        http.authorizeRequests().antMatchers("/api/bankAccount").permitAll();
        http.csrf().disable();
    }
}
