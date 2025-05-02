package ru.facture.main.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerStatisticDto {
    private String manufacturerName;
    private Long count;
    private Double percent;
    public ManufacturerStatisticDto(String manufacturerName, Long count, Double percent) {
        this.manufacturerName = manufacturerName;
        this.count = count;
        this.percent = percent;
    }
}
