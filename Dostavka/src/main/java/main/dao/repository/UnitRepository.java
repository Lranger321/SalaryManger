package main.dao.repository;

import main.dao.entity.Unit;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Long> {
}
