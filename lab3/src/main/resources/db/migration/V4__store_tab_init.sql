CREATE TABLE eq_shop.store_tab
(
    id         SERIAL PRIMARY KEY,
    store_name varchar(150) NOT NULL
);

COMMENT
ON COLUMN  eq_shop.store_tab.id IS 'Идентификатор филиала';
COMMENT
ON COLUMN eq_shop.store_tab.store_name IS 'Наименование филиала';

INSERT INTO eq_shop.store_tab (store_name)
VALUES ('Магазин Бытовой Техники 1'),
       ('Магазин Бытовой Техники 2'),
       ('Магазин Бытовой Техники 3'),
       ('Магазин Бытовой Техники 4'),
       ('Магазин Бытовой Техники 5');