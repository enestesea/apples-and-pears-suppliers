DROP TABLE IF EXISTS suppliers, products, product_prices, supplies;

CREATE TABLE
    IF NOT EXISTS suppliers (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255) UNIQUE NOT NULL
    );

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    type VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS product_prices (
    id SERIAL PRIMARY KEY,
    supplier_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    price INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
    );
CREATE TABLE IF NOT EXISTS supplies (
    id SERIAL PRIMARY KEY,
    supplier_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    supply_date DATE NOT NULL,
    price FLOAT

);
