package ru.tds.application.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.tds.application.domain.LogEntity;
import ru.tds.application.domain.UsersEntity;
import ru.tds.application.repositories.LogRepository;
import ru.tds.application.repositories.UsersRepository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Класс,в котором реализована запись информации о пользователе в таблицу log, когда пользователь выполняет защищенные запросы /user/**
 *
 * @author Трушенков Дмитрий
 */
@Component
@Aspect
public class LogSecurityAspect implements ApplicationListener<AuthenticationSuccessEvent>{

//    private final UsersRepository userRepository;

    private final LogRepository repository;

    @Autowired
    public LogSecurityAspect(LogRepository repository) {
        this.repository = repository;
    }

//    @Around("execution(* ru.tds.application.controllers.UsersController.findAll(..))")
//    public Object writeLog(ProceedingJoinPoint pjp) throws Throwable {
//
//        UsersEntity user = userRepository.getById(3);
//        LogEntity log = new LogEntity();
//
//        java.util.Date today = new java.util.Date();//Текущая дата
//        System.out.println(new java.sql.Time(today.getTime())); //Текущее время
//
//        //Запись в таблицу log новой строки, содержащей данные о пользователе
//        log.setId(1);
//        log.setUserLogin(user.getLogin());
//        log.setDateLogin(new Date(today.getTime()));
//        log.setDateLogout(new Date(118, 5, 5));
//
//        repository.save(log);
//
//        return pjp.proceed();
//    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        User userName = (User) event.getAuthentication().getPrincipal();
        LogEntity log = new LogEntity();
        try {
            log.setId(1);
            log.setDateLogin(new Time(System.currentTimeMillis() - 3600 * 1000));
            log.setUserLogin(userName.getUsername());
            repository.saveAndFlush(log);
        } catch (Exception ignored) {
        }


    }
}
