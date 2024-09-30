package cqrs.my.demo.course.demography.app.api;

import cqrs.my.demo.course.demography.domain.PatientDetails;

public interface GetDetailsInbound {
    /**
     * Получить информацию о пациенте
     *
     * @param userId внешний ID пациента
     * @return информация
     */
    PatientDetails getDetails(String userId);
}
