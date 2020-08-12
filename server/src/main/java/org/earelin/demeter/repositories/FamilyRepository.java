package org.earelin.demeter.repositories;

import java.util.List;
import org.earelin.demeter.domain.plants.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Long> {
  List<Family> findAllByOrderByName();
}
