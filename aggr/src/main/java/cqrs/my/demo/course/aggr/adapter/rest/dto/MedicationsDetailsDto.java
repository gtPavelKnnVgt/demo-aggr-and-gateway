package cqrs.my.demo.course.aggr.adapter.rest.dto;

import lombok.Data;

@Data
public class MedicationsDetailsDto {
    /**
     * Наименование медикамента
     */
    private String medicationName;
}
