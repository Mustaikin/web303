CREATE TABLE eq_shop.manufacturer_tab
(
    id                SERIAL PRIMARY KEY,
    manufacturer_name varchar(150) NOT NULL
);
COMMENT
ON COLUMN  eq_shop.manufacturer_tab.id IS 'Идентификатор производителя';
COMMENT
ON COLUMN eq_shop.manufacturer_tab.manufacturer_name IS 'Наименование производителя';

INSERT INTO eq_shop.manufacturer_tab (manufacturer_name)
VALUES ('LG'),
       ('Samsung'),
       ('Bosch'),
       ('Whirlpool'),
       ('Electrolux'),
       ('Philips'),
       ('Panasonic'),
       ('Miele'),
       ('Siemens'),
       ('Tefal');