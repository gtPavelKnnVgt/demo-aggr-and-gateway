package cqrs.my.demo.course.aggr.adapter.demography;

import cqrs.my.demo.course.aggr.adapter.demography.dto.DemographyDto;
import cqrs.my.demo.course.aggr.app.api.GetDemographyOutbound;
import cqrs.my.demo.course.aggr.domain.PatientDetails;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DemographyAdapter implements GetDemographyOutbound {
    private final DemographyFeignClient demographyClient;

    @Override
    public PatientDetails getDemography(String userId) {
        log.info("Getting demography info by user_external_id: {}", userId);
        try {
            DemographyDto details = demographyClient.getDetails(userId);
            return new PatientDetails()
                    .setAddress(details.address())
                    .setBirth(details.birth())
                    .setFio(details.fio())
                    .setUserExternalId(userId);
        } catch (FeignException e) {
            log.info("Something went wrong: {}", e.getMessage());
        }
        return null;
    }
}
