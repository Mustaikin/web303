CREATE TABLE eq_shop.delivery_tab
(
    id            SERIAL PRIMARY KEY,
    delivery_date TIMESTAMP NOT NULL,
    product_id    INTEGER   NOT NULL,
    store_id      INTEGER   NOT NULL,
    product_count INTEGER   NOT NULL,
    FOREIGN KEY (product_id) REFERENCES eq_shop.product_tab (id)
);

COMMENT
    ON COLUMN eq_shop.delivery_tab.id IS 'Идентификатор';
COMMENT
    ON COLUMN eq_shop.delivery_tab.delivery_date IS 'Дата поставки';
COMMENT
    ON COLUMN eq_shop.delivery_tab.product_id IS 'Идентификатор товара. Внешний ключ к product_tab.id';
COMMENT
    ON COLUMN eq_shop.delivery_tab.store_id IS 'Идентификатор товара. Внешний ключ к store_tab.id';
COMMENT
    ON COLUMN eq_shop.delivery_tab.product_count IS 'Количество товара';


INSERT INTO eq_shop.delivery_tab (store_id, delivery_date, product_id, product_count)
VALUES (1, '2023-01-15 10:00:00', 1, 30),
       (1, '2023-01-20 10:00:00', 2, 20),
       (2, '2023-01-18 11:00:00', 3, 25),
       (3, '2023-01-22 12:00:00', 4, 15),
       (4, '2023-01-25 13:00:00', 5, 40),
       (5, '2023-01-30 14:00:00', 6, 50);