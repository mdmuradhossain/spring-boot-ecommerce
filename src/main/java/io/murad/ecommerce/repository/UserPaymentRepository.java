package io.murad.ecommerce.repository;


import io.murad.ecommerce.model.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

}
