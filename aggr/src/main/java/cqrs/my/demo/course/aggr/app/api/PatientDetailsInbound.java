package cqrs.my.demo.course.aggr.app.api;

import cqrs.my.demo.course.aggr.domain.PatientDetails;

public interface PatientDetailsInbound {
    /**
     * Подготовить информацию по профилю пациента по его внешнему ID
     *
     * @param userExternalId Внешний ID
     * @return подготовленная информация
     */
    PatientDetails prepare(String userExternalId);
}
