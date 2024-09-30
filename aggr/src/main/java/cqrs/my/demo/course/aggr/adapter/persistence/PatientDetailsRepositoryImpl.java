package cqrs.my.demo.course.aggr.adapter.persistence;

import cqrs.my.demo.course.aggr.app.api.PatientDetailsRepository;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PatientDetailsRepositoryImpl implements PatientDetailsRepository {
    private final PatientDetailsJpaRepository jpaRepository;

    @Override
    public PatientDetails create(PatientDetails patientDetails) {
        return jpaRepository.save(patientDetails);
    }
}
