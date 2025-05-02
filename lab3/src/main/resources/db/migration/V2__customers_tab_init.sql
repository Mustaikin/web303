CREATE TABLE eq_shop.customer_tab
(
    id          SERIAL PRIMARY KEY,
    first_name  varchar(100) NOT NULL,
    last_name   varchar(100) NOT NULL,
    middle_name varchar(100)
);

COMMENT
ON COLUMN  eq_shop.customer_tab.id IS 'Идентификатор покупателя';
COMMENT
ON COLUMN eq_shop.customer_tab.first_name IS 'Имя покупателя';
COMMENT
ON COLUMN eq_shop.customer_tab.last_name IS 'Фамилия покупателя';
COMMENT
ON COLUMN eq_shop.customer_tab.middle_name IS 'Отчество покупателя';

INSERT INTO eq_shop.customer_tab (first_name, middle_name, last_name)
VALUES ('Алексей', 'Александрович', 'Алексеев'),
       ('Марина', 'Сергеевна', 'Сергеев'),
       ('Дмитрий', 'Дмитриевич', 'Дмитриев'),
       ('Елена', 'Викторовна', 'Викторова'),
       ('Светлана', 'Петровна', 'Петрова');
