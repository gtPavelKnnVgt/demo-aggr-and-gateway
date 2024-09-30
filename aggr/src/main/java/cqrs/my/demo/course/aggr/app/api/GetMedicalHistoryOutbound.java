package cqrs.my.demo.course.aggr.app.api;

import cqrs.my.demo.course.aggr.domain.PatientDetails;

public interface GetMedicalHistoryOutbound {
    /**
     * Подготовить мед историю о пациент
     *
     * @param userId ID пациента
     * @return подготовленная мед история
     */
    PatientDetails getMedicalHistory(String userId);
}
