package io.github.com.creditappraisalms.client;

import io.github.com.creditappraisalms.domain.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${ms.customer.name}", path = "${ms.customer.path}")
public interface CustomerClient {
    @GetMapping(params = {"cpf"})
    ResponseEntity<CustomerData> getCustomer(@RequestParam("cpf") String cpf);
}
