package ru.facture.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerPurchaseInfoDto {
    private String firstName;
    private String lastName;
    private Long purchaseCount;
}
