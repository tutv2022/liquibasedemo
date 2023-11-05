--liquibase formatted sql
--changeset eliedaher:0001-02

INSERT INTO product (key, description)
VALUES ('PRODUCT_A', 'Product A'),
       ('PRODUCT_B', 'Product B'),
       ('PRODUCT_C', 'Product C');

-- rollback DELETE FROM product WHERE key IN ('PRODUCT_A', 'PRODUCT_B', 'PRODUCT_C');
