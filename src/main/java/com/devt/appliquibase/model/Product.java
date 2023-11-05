package com.devt.appliquibase.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(generator = "product_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "key", length = 64)
    private String key;

    @Column(name = "description")
    private String description;

}