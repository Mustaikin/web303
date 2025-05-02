package ru.facture.main.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.facture.main.Entity.Purchase;
import ru.facture.main.dto.CustomerPurchaseInfoDto;

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

}