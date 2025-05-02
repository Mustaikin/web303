package ru.facture.main.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.facture.main.Entity.Purchase;
import ru.facture.main.dto.CustomerPurchaseInfoDto;
import ru.facture.main.dto.ManufacturerStatisticDto;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    @Query("""
                SELECT new ru.facture.main.dto.CustomerPurchaseInfoDto(
                    c.firstName, c.lastName, COUNT(p)
                )
                FROM Purchase p
                JOIN p.customer c
                GROUP BY c.id, c.firstName, c.lastName
            """)
    List<CustomerPurchaseInfoDto> getCustomerPurchaseInfo();



    @Query("""
    SELECT new ru.facture.main.dto.ManufacturerStatisticDto(
        m.name,
        SUM(pit.productCount),
        cast(0.0 AS Double)
    )
    FROM PurchaseItem pit
    JOIN pit.product p
    JOIN p.manufacturer m
    GROUP BY m.name
    ORDER BY SUM(pit.productCount) DESC
""")
    List<ManufacturerStatisticDto> getManufacturerStats();

}