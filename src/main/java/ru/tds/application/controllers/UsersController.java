package ru.tds.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController{

    @RequestMapping(value = "/hello")
    public String findById(){
        return "HI!";
    }

}
