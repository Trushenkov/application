package ru.tds.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.tds.application.domain.RolesEntity;
import ru.tds.application.repositories.RolesRepository;

@RestController
public class RoleController {

    @Autowired
    private RolesRepository repository;

    /**
     * Метод для сохранения новой роли в таблицу roles
     *
     * @return новый пользователь в базе данных
     */
    @RequestMapping(value = "/role/save/super_admin", method = RequestMethod.GET)
    public RolesEntity saveUser() {
        return repository.save(
                new RolesEntity(3, "SUPER_ADMIN", "This id role for SUPER ADMIN"));
    }

    /**
     * Метод для выбора из таблицы роли со значением id=1
     *
     * @return роль со значением id=1
     */
    @RequestMapping(value = "/role/1")
    public String role1() {
        return "Пользователь со значением  id = 1: <br>"
                + repository.findById(1).toString();
    }

    /**
     * Метод для выбора из таблицы роли со значением id=2
     *
     * @return роль со значением id=2
     */
    @RequestMapping(value = "/role/2")
    public String role2() {
        return "Пользователь со значением  id = 2: <br>"
                + repository.findById(2).toString();
    }

    /**
     * Метод для выбора из таблицы роли со значением id=3
     *
     * @return роль со значением id=3
     */
    @RequestMapping(value = "/role/3")
    public String role3() {
        return "Роль со значением  id = 3: <br>"
                + repository.findById(3).toString();
    }

    /**
     * Метод для выбора всех записей из таблицы roles
     *
     * @return все записи из таблицы
     */
    @RequestMapping(value = "/role/all")
    public String roleAll() {
        return "Все роли из таблицы roles: <br> " + repository.findAll().toString();
    }


}
