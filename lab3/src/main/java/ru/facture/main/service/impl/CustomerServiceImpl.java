package ru.facture.main.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.facture.main.dto.CustomerPurchaseInfoDto;
import ru.facture.main.dto.CustomerPurchasesDto;
import ru.facture.main.dto.PurchaseDto;
import ru.facture.main.dto.PurchaseItemDto;
import ru.facture.main.repositories.PurchaseRepository;
import ru.facture.main.service.CustomerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final PurchaseRepository purchaseRepository;

    public CustomerServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Map<String, List<CustomerPurchaseInfoDto>> getCustomerInfo() {
        List<CustomerPurchaseInfoDto> customerList = purchaseRepository.getCustomerPurchaseInfo();
        return Map.of("customerList", customerList);
    }

    @Override
    public ResponseEntity<CustomerPurchasesDto> getCustomerPurchases(Long customerId) {
        List<Object[]> rawData = purchaseRepository.getCustomerPurchaseData(customerId);

        if (rawData.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент или покупки не найдены");
        }

        Object[] firstRow = rawData.get(0);
        Long id = ((Number) firstRow[0]).longValue();
        String name = (String) firstRow[1];
        String secondName = (String) firstRow[2];
        var customer = new CustomerPurchasesDto.CustomerInfo(id, name, secondName);

        Map<Long, PurchaseDto> purchasesMap = new LinkedHashMap<>();

        for (Object[] row : rawData) {
            Long purchaseId = ((Number) row[3]).longValue();
            LocalDate purchaseDate = ((java.sql.Date) row[4]).toLocalDate();
            String productName = (String) row[5];
            int count = ((Number) row[6]).intValue();
            BigDecimal price = (BigDecimal) row[7];

            PurchaseItemDto item = new PurchaseItemDto(productName, count, price);
            purchasesMap
                    .computeIfAbsent(purchaseId, id_ -> new PurchaseDto(purchaseId, purchaseDate, new ArrayList<>()))
                    .getItemList().add(item);
        }

        return ResponseEntity.ok(new CustomerPurchasesDto(customer, new ArrayList<>(purchasesMap.values())));
    }
}
