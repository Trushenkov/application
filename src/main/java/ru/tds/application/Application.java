package ru.tds.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@EnableWebSecurity
@SpringBootApplication
@ComponentScan
public class Application extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("admin").password("admin1").roles("ADMIN"));
//                .and()
//                .inMemoryAuthentication().withUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER"));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));

        http.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN");

//        http.authorizeRequests().antMatchers("/role/**").hasRole("ADMIN");


        http.httpBasic();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}