package cqrs.my.demo.course.aggr.app.impl;

import cqrs.my.demo.course.aggr.app.api.GetDemographyOutbound;
import cqrs.my.demo.course.aggr.app.api.GetMedicalHistoryOutbound;
import cqrs.my.demo.course.aggr.app.api.PatientDetailsInbound;
import cqrs.my.demo.course.aggr.app.api.PatientDetailsRepository;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientDetailsUseCase implements PatientDetailsInbound {
    private final GetDemographyOutbound getDemographyOutbound;
    private final GetMedicalHistoryOutbound getMedicalHistoryOutbound;
    private final PatientDetailsRepository patientDetailsRepository;

    @Override
    @Transactional
    public PatientDetails prepare(String userExternalId) {
        log.info("Preparing aggregated details by patient ext id: {}", userExternalId);
        PatientDetails details = getDemographyOutbound.getDemography(userExternalId);

        PatientDetails medicalHistory = getMedicalHistoryOutbound.getMedicalHistory(userExternalId);

        details
                .setAllergies(medicalHistory.getAllergies())
                .setMedications(medicalHistory.getMedications());

        return patientDetailsRepository.create(details);
    }
}
