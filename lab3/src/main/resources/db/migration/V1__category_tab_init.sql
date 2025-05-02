CREATE TABLE eq_shop.category_tab
(
    id            SERIAL PRIMARY KEY,
    category_name varchar(150) NOT NULL
);
COMMENT
ON COLUMN  eq_shop.category_tab.id IS 'Идентификатор категории';
COMMENT
ON COLUMN eq_shop.category_tab.category_name IS 'Наименование категории';

INSERT INTO eq_shop.category_tab (category_name)
VALUES ('Стиральные машины'),
       ('Холодильники'),
       ('Микроволновые печи'),
       ('Пылесосы'),
       ('Кухонные плиты'),
       ('Электрические чайники'),
       ('Блендеры'),
       ('Кофеварки');

