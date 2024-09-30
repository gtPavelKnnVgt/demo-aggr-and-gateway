package cqrs.my.demo.course.aggr.adapter.rest.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDetailsDto {
    private String fio;
    private String userExternalId;
    private LocalDate birth;
    private String address;
    private List<AllergiesDetailsDto> allergies;
    private List<MedicationsDetailsDto> medications;
}
