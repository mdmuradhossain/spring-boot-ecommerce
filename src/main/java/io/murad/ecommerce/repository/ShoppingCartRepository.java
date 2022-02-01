package io.murad.ecommerce.repository;

import io.murad.ecommerce.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
