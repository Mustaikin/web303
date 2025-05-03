package ru.facture.main.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import ru.facture.main.dto.CustomerPurchaseInfoDto;
import ru.facture.main.dto.CustomerPurchasesDto;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    Map<String, List<CustomerPurchaseInfoDto>> getCustomerInfo();
    ResponseEntity<CustomerPurchasesDto> getCustomerPurchases(Long customerId);
}
