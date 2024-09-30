package cqrs.my.demo.course.aggr.adapter.rest.dto;

import lombok.Data;

@Data
public class AllergiesDetailsDto {
    /**
     * Наименование аллергии
     */
    private String allergyName;
}
