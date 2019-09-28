package fpt.asignmentspringboot.service;

import fpt.asignmentspringboot.entity.AptechClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AptechClazzRepository extends JpaRepository<AptechClass,Long> {
    AptechClass findById(long clazzId);
}
