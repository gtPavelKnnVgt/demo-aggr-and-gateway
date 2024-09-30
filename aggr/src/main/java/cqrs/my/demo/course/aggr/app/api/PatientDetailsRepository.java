package cqrs.my.demo.course.aggr.app.api;

import cqrs.my.demo.course.aggr.domain.PatientDetails;

public interface PatientDetailsRepository {
    /**
     * Сохранить информацию о пациенте
     *
     * @param patientDetails информация для сохранения
     * @return сохраненные данные
     */
    PatientDetails create(PatientDetails patientDetails);
}
