package cqrs.my.demo.course.aggr.adapter.persistence;

import cqrs.my.demo.course.aggr.domain.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDetailsJpaRepository extends JpaRepository<PatientDetails, Long> {
}
