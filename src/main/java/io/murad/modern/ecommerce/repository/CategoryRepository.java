package io.murad.modern.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.murad.modern.ecommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
