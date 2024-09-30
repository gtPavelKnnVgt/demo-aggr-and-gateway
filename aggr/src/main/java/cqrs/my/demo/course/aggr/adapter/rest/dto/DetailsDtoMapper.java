package cqrs.my.demo.course.aggr.adapter.rest.dto;

import cqrs.my.demo.course.aggr.domain.PatientAllergy;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import cqrs.my.demo.course.aggr.domain.PatientMedications;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailsDtoMapper {

    UserDetailsDto mapToDto(PatientDetails source);

    @Mapping(target = "allergyName", source = "allergyName")
    AllergiesDetailsDto mapToDto(PatientAllergy source);

    @Mapping(target = "medicationName", source = "medicationName")
    MedicationsDetailsDto mapToDto(PatientMedications source);

    @AfterMapping
    default void mapToDto(PatientDetails source, @MappingTarget UserDetailsDto dto) {
        List<AllergiesDetailsDto> allergies = source.getAllergies().stream()
                .map(this::mapToDto).toList();
        List<MedicationsDetailsDto> medications = source.getMedications().stream()
                .map(this::mapToDto).toList();
        dto.setAllergies(allergies);
        dto.setMedications(medications);
    }
}
