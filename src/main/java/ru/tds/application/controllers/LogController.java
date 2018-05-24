package ru.tds.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tds.application.repositories.LogRepository;

@RestController
public class LogController {

    @Autowired
    private LogRepository repository;

    /**
     * Метод для выбора всех записей из таблицы log
     *
     * @return все записи из таблицы log
     */
    @RequestMapping(value = "log/all")
    public String logAll() {
        return "Список всех записей в таблице log: <br>"
                + repository.findAll().toString();
    }

    /**
     * Метод для выбора из таблицы log записи, в которой значение id=1
     *
     * @return запись со значением id=1
     */
    @RequestMapping(value = "log/1")
    public String log1() {
        return "Log со значением id = 1: <br>" +
                repository.findById(1).toString();
    }


}
