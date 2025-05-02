package ru.facture.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.facture.main.dto.CustomerPurchaseInfoDto;
import ru.facture.main.repositories.PurchaseRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final PurchaseRepository purchaseRepository;

    public CustomerController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("purchases/customerInfo")
    public Map<String, List<CustomerPurchaseInfoDto>> getCustomerInfo() {
        List<CustomerPurchaseInfoDto> customerList = purchaseRepository.getCustomerPurchaseInfo();
        return Map.of("customerList", customerList);
    }
   @GetMapping("purchases/customerInfo1")
    public String getCustomerInfo1() {
        return "Hello";
   }
}
