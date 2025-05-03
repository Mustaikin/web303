package ru.facture.main.service.impl;

import org.springframework.stereotype.Service;
import ru.facture.main.dto.ManufacturerStatisticDto;
import ru.facture.main.repositories.PurchaseRepository;
import ru.facture.main.service.ManufacturerService;

import java.util.List;
import java.util.Map;

@Service
public class ManufacturerImpl implements ManufacturerService {
    private PurchaseRepository purchaseRepository;
    public ManufacturerImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @Override
    public Map<String, Object> getManufactureStats() {
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
