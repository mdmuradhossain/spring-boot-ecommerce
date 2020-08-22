package io.murad.modern.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.murad.modern.ecommerce.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>{

}
