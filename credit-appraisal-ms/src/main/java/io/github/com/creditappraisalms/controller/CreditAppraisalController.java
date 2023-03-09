package io.github.com.creditappraisalms.controller;

import io.github.com.creditappraisalms.service.CreditAppraisalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-appraisal")
@RequiredArgsConstructor
@Slf4j
public class CreditAppraisalController {
    private final CreditAppraisalService creditAppraisalService;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Health-check - OK");
        return "OK";
    }

}
