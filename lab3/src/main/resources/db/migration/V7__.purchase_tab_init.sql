CREATE TABLE eq_shop.purchase_tab
(
    id            SERIAL PRIMARY KEY,
    purchase_date TIMESTAMP NOT NULL,
    customer_id   INTEGER   NOT NULL,
    store_id      INTEGER   NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES eq_shop.customer_tab (id),
    FOREIGN KEY (store_id) REFERENCES eq_shop.store_tab (id)
);
COMMENT ON column eq_shop.purchase_tab.id IS 'Идентификатор покупки';
COMMENT ON column eq_shop.purchase_tab.purchase_date IS 'Дата покупки';
COMMENT ON column eq_shop.purchase_tab.customer_id IS 'Идендифиактор покупателя. Внешний ключ к customer_tab.id';
COMMENT ON column eq_shop.purchase_tab.store_id IS 'Идентифиактор филиалаю Внешний ключ к store_tab.id';

INSERT INTO eq_shop.purchase_tab (customer_id, store_id, purchase_date)
VALUES (1, 1, '2023-02-01'), -- Алексеев
       (1, 2, '2023-02-10'), -- Алексеев
       (2, 2, '2023-02-02'), -- Сергеев
       (3, 3, '2023-02-03'), -- Дмитриев
       (4, 4, '2023-02-04'), -- Викторова
       (5, 5, '2023-02-05'), -- Петрова
       (1, 3, '2023-02-15'); -- Алексеев
