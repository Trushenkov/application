package ru.tds.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tds.application.mappings.UsersEntity;

@Repository
public interface LogRepository extends CrudRepository<UsersEntity, Integer> {
}
