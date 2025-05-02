package ru.facture.main.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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


    @Query(value = """
    SELECT 
        c.id AS customer_id,
        c.first_name,
        c.last_name,
        p.id AS purchase_id,
        p.purchase_date,
        pr.product_name AS product_name,
        pi.product_count,
        pi.product_price
    FROM eq_shop.customer_tab c
    JOIN eq_shop.purchase_tab p ON p.customer_id = c.id
    JOIN eq_shop.purchase_item_tab pi ON pi.purchase_id = p.id
    JOIN eq_shop.product_tab pr ON pr.id = pi.product_id
    WHERE c.id = :customerId
    ORDER BY p.purchase_date
    """, nativeQuery = true)
    List<Object[]> getCustomerPurchaseData(@Param("customerId") Long customerId);

}