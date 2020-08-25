package io.murad.modern.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.murad.modern.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
