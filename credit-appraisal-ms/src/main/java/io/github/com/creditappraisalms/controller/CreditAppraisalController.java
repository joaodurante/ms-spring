package io.github.com.creditappraisalms.controller;

import io.github.com.creditappraisalms.dto.AppraisalData;
import io.github.com.creditappraisalms.dto.CustomerAppraisalResponse;
import io.github.com.creditappraisalms.dto.CustomerStatus;
import io.github.com.creditappraisalms.ex.CustomerDataNotFoundException;
import io.github.com.creditappraisalms.ex.MsCommunicationException;
import io.github.com.creditappraisalms.service.CreditAppraisalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/customerStatus", params = {"cpf"})
    public ResponseEntity checkCustomerStatus(@RequestParam("cpf") String cpf) {
        try {
            CustomerStatus customerStatus = creditAppraisalService.checkCustomerStatus(cpf);
            return ResponseEntity.ok(customerStatus);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (MsCommunicationException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("/appraiseCustomerCredit")
    public ResponseEntity appraiseCustomerCredit(@RequestBody AppraisalData data) {
        try {
            CustomerAppraisalResponse appraisal = creditAppraisalService.appraiseCustomerCredit(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(appraisal);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (MsCommunicationException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

}
