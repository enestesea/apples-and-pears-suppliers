INSERT INTO suppliers (name)
VALUES ('Поставщик 1'),
       ('Поставщик 2'),
       ('Поставщик 3');

INSERT INTO products (name, type)
VALUES ('Яблоко тип 1', 'APPLE'),
       ('Яблоко тип 2', 'APPLE'),
       ('Груша тип 1', 'PEAR'),
       ('Груша тип 2', 'PEAR');

SET datestyle = 'ISO';

INSERT INTO product_prices (supplier_id, product_id,
                           price, start_date, end_date)
VALUES (1, 1, 150, '2024-01-20 00:00:00', '2024-05-25 00:00:00'), (2, 1, 300, '2024-01-20 00:00:00', '2024-05-25 00:00:00');