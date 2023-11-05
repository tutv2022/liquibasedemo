package com.devt.appliquibase.repository;

import com.devt.appliquibase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEntityRepository extends JpaRepository<Product, Integer> {
}
