package ru.tds.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tds.application.domain.LogEntity;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Integer> {
}
