package ru.facture.main.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "purchase_item_tab", schema = "eq_shop")
@Getter
@Setter
public class PurchaseItem {
    @EmbeddedId
    private PurchaseItemId id;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_count", nullable = false)
    private int productCount;

    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;
}
