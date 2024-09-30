package cqrs.my.demo.course.aggr.app.api;

import cqrs.my.demo.course.aggr.domain.PatientDetails;

public interface GetDemographyOutbound {
    /**
     * Подготовить данные о демографии пациента
     *
     * @param userId Внешний ID пользователя
     * @return информация о демографии
     */
    PatientDetails getDemography(String userId);
}
