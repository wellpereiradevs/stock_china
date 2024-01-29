CREATE TABLE tb_products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    price_sale DECIMAL,
    price_purchase DECIMAL,
    minimum_stock BIGINT,
    stock_quant BIGINT
)