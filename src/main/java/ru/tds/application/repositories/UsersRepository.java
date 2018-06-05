package ru.tds.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tds.application.domain.UsersEntity;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    List<UsersEntity> findByFirstName(String firstName);

    List<UsersEntity> findByRoleEquals(int value);

    UsersEntity getById(int id);

}
