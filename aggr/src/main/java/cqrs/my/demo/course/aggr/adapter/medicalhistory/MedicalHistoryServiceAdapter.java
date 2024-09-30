package cqrs.my.demo.course.aggr.adapter.medicalhistory;

import cqrs.my.demo.course.aggr.app.api.GetMedicalHistoryOutbound;
import cqrs.my.demo.course.aggr.domain.PatientAllergy;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import cqrs.my.demo.course.aggr.domain.PatientMedications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MedicalHistoryServiceAdapter implements GetMedicalHistoryOutbound {
    public PatientDetails getMedicalHistory(String userId) {
        log.info("Getting medical_history info by user_external_id: {}", userId);
        return new PatientDetails()
                .setMedications(prepareMedications())
                .setAllergies(prepareAllergies());
    }

    private List<PatientMedications> prepareMedications() {
        PatientMedications medication1 = new PatientMedications().setMedicationName("Peanuts");
        PatientMedications medication2 = new PatientMedications().setMedicationName("Shellfish");
        return new ArrayList<>(List.of(medication1, medication2));
    }

    private List<PatientAllergy> prepareAllergies() {
        PatientAllergy allergy1 = new PatientAllergy().setAllergyName("Aspirin");
        PatientAllergy allergy2 = new PatientAllergy().setAllergyName("Ibuprofen");
        return new ArrayList<>(List.of(allergy1, allergy2));
    }
}
