package ru.facture.main.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PurchaseDto {
    private Long id;
    private LocalDate purchaseDate;
    private List<PurchaseItemDto> itemList;

    public PurchaseDto(Long id, LocalDate purchaseDate, List<PurchaseItemDto> itemList) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.itemList = itemList;
    }



}
