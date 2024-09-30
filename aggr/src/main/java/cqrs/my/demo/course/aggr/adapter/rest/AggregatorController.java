package cqrs.my.demo.course.aggr.adapter.rest;

import cqrs.my.demo.course.aggr.adapter.rest.dto.DetailsDtoMapper;
import cqrs.my.demo.course.aggr.adapter.rest.dto.UserDetailsDto;
import cqrs.my.demo.course.aggr.app.api.PatientDetailsInbound;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ext/patient-details/aggregate")
@RequiredArgsConstructor
public class AggregatorController {
    private final PatientDetailsInbound patientDetailsInbound;
    private final DetailsDtoMapper mapper;

    @GetMapping("/{userId}")
    public UserDetailsDto aggregateUserDetails(@PathVariable String userId) {
        PatientDetails details = patientDetailsInbound.prepare(userId);
        return mapper.mapToDto(details);
    }
}