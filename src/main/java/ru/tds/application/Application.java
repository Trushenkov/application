package ru.tds.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import ru.tds.application.domain.UsersEntity;
import ru.tds.application.repositories.UsersRepository;

/**
 * Класс, в котором реализован запуск приложения и предоставление права ADMIN пользователю с id=3 из таблицы USERS
 *
 * @author Трушенков Дмитрий
 */
@EnableWebSecurity
@SpringBootApplication
@ComponentScan
public class Application extends WebSecurityConfigurerAdapter {

    private final UsersRepository repository;

    @Autowired
    public Application(UsersRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        UsersEntity user = repository.getById(3);
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username(user.getLogin()).password(user.getPassword()).roles("ADMIN"));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));

        http.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN");

        http.httpBasic();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}