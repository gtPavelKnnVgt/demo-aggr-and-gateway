package cqrs.my.demo.course.aggr.adapter.demography.dto;

import java.time.LocalDate;

public record DemographyDto(String fio, String address, LocalDate birth, String userExtId) {
}
