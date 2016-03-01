package com.books.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by Simba on 2/27/2016.
 */
@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static  String PROPERTY_USER = "basic.user";
    private static  String PROPERTY_PASSWORD = "basic.password";
    @Resource
    private Environment env;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
      String username=env.getRequiredProperty(PROPERTY_USER),password=env.getRequiredProperty(PROPERTY_PASSWORD);
        builder.inMemoryAuthentication()
                .withUser(username).password(password).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
    }
}
