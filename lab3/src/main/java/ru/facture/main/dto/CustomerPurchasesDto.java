package ru.facture.main.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerPurchasesDto {

    private CustomerInfo customer;
    private List<PurchaseDto> purchiseList;

    public CustomerPurchasesDto(CustomerInfo customer, List<PurchaseDto> purchiseList) {
        this.customer = customer;
        this.purchiseList = purchiseList;
    }

    @Getter
    @Setter
    public static class CustomerInfo {
        private Long id;
        private String name;
        private String secondName;

        public CustomerInfo(Long id, String name, String secondName) {
            this.id = id;
            this.name = name;
            this.secondName = secondName;
        }
    }
}
