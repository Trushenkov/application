package ru.tds.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tds.application.mappings.RolesEntity;


@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {
}
