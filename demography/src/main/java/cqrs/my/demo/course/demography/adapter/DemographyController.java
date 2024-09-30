package cqrs.my.demo.course.demography.adapter;

import cqrs.my.demo.course.demography.adapter.dto.DemographyDto;
import cqrs.my.demo.course.demography.app.api.GetDetailsInbound;
import cqrs.my.demo.course.demography.domain.PatientDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient-details")
@RequiredArgsConstructor
public class DemographyController {
    private final GetDetailsInbound getDetailsInbound;

        @GetMapping("/{userId}")
    public DemographyDto getDetails(@PathVariable("userId") String userId) {
        PatientDetails details = getDetailsInbound.getDetails(userId);
        return new DemographyDto(
                details.fio(),
                details.address(),
                details.birth(),
                details.userExtId());
    }
}
