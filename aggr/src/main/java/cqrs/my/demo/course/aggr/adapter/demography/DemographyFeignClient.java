package cqrs.my.demo.course.aggr.adapter.demography;

import cqrs.my.demo.course.aggr.adapter.demography.dto.DemographyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "demography", url = "${service.demography.api.url}")
public interface DemographyFeignClient {
    @GetMapping("/api/v1/patient-details/{userId}")
    DemographyDto getDetails(@PathVariable String userId);
}
