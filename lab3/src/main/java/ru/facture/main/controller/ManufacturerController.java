package ru.facture.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.facture.main.dto.ManufacturerStatisticDto;
import ru.facture.main.repositories.PurchaseRepository;
import ru.facture.main.service.ManufacturerService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ManufacturerController {
    private ManufacturerService manufacturerService;
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/manufacturerStatistic")
    public Map<String, Object> getManufactureStats(){
       return manufacturerService.getManufactureStats();
    }
}
