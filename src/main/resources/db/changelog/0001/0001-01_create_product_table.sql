--liquibase formatted sql
--changeset eliedaher:0001-01

CREATE SEQUENCE product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE product (
    id INTEGER NOT NULL DEFAULT NEXTVAL('product_id_seq') PRIMARY KEY,
    key CHARACTER VARYING(64),
    description CHARACTER VARYING(255)
);

-- rollback DROP TABLE product;
-- rollback DROP SEQUENCE product_id_seq;
