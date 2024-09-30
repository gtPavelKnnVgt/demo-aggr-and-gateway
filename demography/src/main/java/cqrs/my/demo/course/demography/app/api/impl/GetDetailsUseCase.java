package cqrs.my.demo.course.demography.app.api.impl;

import cqrs.my.demo.course.demography.app.api.GetDetailsInbound;
import cqrs.my.demo.course.demography.domain.PatientDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetDetailsUseCase implements GetDetailsInbound {
    @Override
    @Transactional(readOnly = true)
    public PatientDetails getDetails(String userId) {
        log.info("Getting demography info by user_external_id: {}", userId);
        return new PatientDetails(
                "John Doe",
                "123 Main St",
                LocalDate.of(2001, 1, 1),
                userId);
    }
}
