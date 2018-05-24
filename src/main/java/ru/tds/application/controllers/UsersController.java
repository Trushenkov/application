package ru.tds.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tds.application.domain.UsersEntity;
import ru.tds.application.repositories.UsersRepository;

import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository repository;

    /**
     * Метод для сохранения нового пользователя в таблицу users
     *
     * @return новый пользователь в базе данных
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    public UsersEntity saveUser() {
        return repository.save(
                new UsersEntity(
                        5,
                        "Дмитрий",
                        "Трушенков",
                        "dmitry",
                        "password",
                        true,
                        1));
    }

    @RequestMapping(value = "user/all")
    public String findAll() {
        return "Список всех пользователей: <br>"
                + repository.findAll().toString();
    }

    /**
     * Метод для обновления записи в таблице users
     *
     * @return обновленная запис в таблице
     */
    @RequestMapping(value = "user/update/1", method = RequestMethod.GET)
    public UsersEntity update() {
        return repository.save(
                new UsersEntity(
                        5,
                        "Дмитрий",
                        "Трушенков",
                        "dmi",
                        "pass",
                        true,
                        1));
    }

    /**
     * Метод для поиска в таблице users всех пользователей, у которых поле role = 1
     *
     * @return список пользователей, у которых role=1
     */
    @RequestMapping(value = "user/role1")
    public String role1() {
        return "Пользователи со значениями поля role = 1: <br>"
                + repository.findByRoleEquals(1).toString();
    }

    /**
     * Метод для поиска в таблице users всех пользователей, у которых поле role = 2
     *
     * @return список пользователей, у которых role=2
     */
    @RequestMapping(value = "user/role2")
    public String role2() {
        return "Пользователи со значениями поля role = 2:<br>"
                + repository.findByRoleEquals(2).toString();
    }

    /**
     * Метод для поиска в таблице users пользователя с именем Иван
     *
     * @return пользователь с именем Иван
     */
    @RequestMapping(value = "/user/ivan")
    public String findIvan() {
        return "Пользователь с именем Иван:<br>"
                + (repository.findByFirstName("Иван")).toString();
    }


    /**
     * Метод для поиска в таблице users пользователя с id = 1
     *
     * @return пользователь с id = 1
     */
    @RequestMapping(value = "/user/1")
    public String id1() {
        return "Пользователь со значением  id = 1: <br>"
                + repository.findById(1).toString();
    }

    /**
     * Метод для поиска в таблице users пользователя с id = 2
     *
     * @return пользователь с id = 2
     */
    @RequestMapping(value = "/user/2")
    public String id2() {
        return "Пользователь со значением  id = 2: <br>"
                + repository.findById(2).toString();
    }

    /**
     * Метод для поиска в таблице users пользователя с id = 3
     *
     * @return пользователь с id = 3
     */
    @RequestMapping(value = "/user/3")
    public String id3() {
        return "Пользователь со значением  id = 3: <br>"
                + repository.findById(3).toString();
    }

    /**
     * Метод для поиска в таблице users пользователя с id = 4
     *
     * @return пользователь с id = 4
     */
    @RequestMapping(value = "/user/4")
    public String id4() {
        return "Пользователь со значением  id = 4: <br>"
                + repository.findById(4).toString();
    }

    /**
     * Метод для поиска в таблице users пользователя с id = 5
     *
     * @return пользователь с id = 5
     */
    @RequestMapping(value = "/user/5")
    public String id5() {
        return "Пользователь со значением  id = 5: <br>"
                + repository.findById(5).toString();
    }

}
