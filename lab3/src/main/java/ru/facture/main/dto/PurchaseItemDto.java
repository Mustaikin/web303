package ru.facture.main.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItemDto {
    private String productName;
    private int count;
    private BigDecimal price;
    public PurchaseItemDto(String productName, int count, BigDecimal price) {
        this.productName = productName;
        this.count = count;
        this.price = price;
    }
}
