CREATE TABLE eq_shop.purchase_item_tab
(
    purchase_id   SERIAL,
    product_id    INT NOT NULL,
    product_count INTEGER         NOT NULL,
    product_price numeric         NOT NULL,
    FOREIGN KEY (purchase_id) REFERENCES eq_shop.purchase_tab (id),
    FOREIGN KEY (product_id) REFERENCES eq_shop.product_tab (id),
    PRIMARY KEY (purchase_id, product_id)
);
COMMENT ON COLUMN eq_shop.purchase_item_tab.purchase_id IS 'Идентификатор покупки. Внешний ключ к purchase_tab.id. Часть составного PK';
COMMENT ON COLUMN eq_shop.purchase_item_tab.product_id IS 'Идентификатор продукта. Внешний ключ к product_tab.id. Часть составного PK';
COMMENT ON COLUMN eq_shop.purchase_item_tab.product_count IS 'Количество товара';
COMMENT ON COLUMN eq_shop.purchase_item_tab.product_price IS 'Цена товара в копейках';


INSERT INTO eq_shop.purchase_item_tab (purchase_id, product_id, product_count, product_price)
VALUES (1, 1, 1, 5000000), -- LG TurboWash
       (1, 2, 1, 6000000), -- Samsung EcoBubble
       (2, 3, 1, 4000000), -- Bosch Serie 4
       (2, 4, 1, 4500000), -- Whirlpool 6th Sense
       (3, 5, 1, 3000000), -- Electrolux EWT 1066
       (4, 6, 1, 800000),  -- Philips HD 9220
       (5, 7, 1, 1200000), -- Panasonic NN-CT56
       (6, 8, 1, 1500000), -- Dyson V11
       (7, 9, 1, 2000000); -- Xiaomi Mi Robot