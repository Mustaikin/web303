package ru.facture.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.facture.main.dto.ManufacturerStatisticDto;
import ru.facture.main.repositories.PurchaseRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ManufacturerController {
    private PurchaseRepository purchaseRepository;
    public ManufacturerController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("/manufacturerStatistic")
    public Map<String, Object> getManufactureStats(){
        List<ManufacturerStatisticDto> manufacturerStatisticDtoList = this.purchaseRepository.getManufacturerStats();
        long total =  manufacturerStatisticDtoList.stream().mapToLong(ManufacturerStatisticDto::getCount).sum();

        for (ManufacturerStatisticDto dto : manufacturerStatisticDtoList) {
            double percent = dto.getCount() * 100.0 / total;
            dto.setPercent(percent);
        }
        return Map.of(
                "total", total,
                "manufacturerList",  manufacturerStatisticDtoList
        );
    }
}
