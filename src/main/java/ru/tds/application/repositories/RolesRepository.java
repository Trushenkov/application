package ru.tds.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tds.application.domain.RolesEntity;


@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {
}
