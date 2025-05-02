package ru.facture.main.Entity;

import java.io.Serializable;
import java.util.Objects;

public class PurchaseItemId implements Serializable {
    private Long purchaseId;
    private Long productId;
    public PurchaseItemId(Long purchaseId, Long productId) {
        this.purchaseId = purchaseId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseItemId that)) return false;
        return Objects.equals(purchaseId, that.purchaseId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, productId);
    }
}
