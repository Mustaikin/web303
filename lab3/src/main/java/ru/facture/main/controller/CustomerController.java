package ru.facture.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.facture.main.dto.CustomerPurchaseInfoDto;
import ru.facture.main.dto.CustomerPurchasesDto;
import ru.facture.main.service.CustomerService;
import ru.facture.main.service.impl.CustomerServiceImpl;
import java.util.*;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/purchases/customerInfo")
    public Map<String, List<CustomerPurchaseInfoDto>> getCustomerInfo() {
        return customerService.getCustomerInfo();
    }

    @GetMapping("/customer/{customerId}/purchases")
    public ResponseEntity<CustomerPurchasesDto> getCustomerPurchases(@PathVariable Long customerId) {
        return customerService.getCustomerPurchases(customerId);
    }

}
