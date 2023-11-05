package com.devt.appliquibase.controller;

import com.devt.appliquibase.exception.NotFoundException;
import com.devt.appliquibase.model.Product;
import com.devt.appliquibase.repository.ProductEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
@AllArgsConstructor
public class ProductController {

    private final ProductEntityRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        final List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        final Product product = repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
        return ResponseEntity.ok(product);
    }

}
