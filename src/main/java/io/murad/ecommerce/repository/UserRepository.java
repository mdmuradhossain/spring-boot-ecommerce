package io.murad.ecommerce.repository;


import io.murad.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

    User findByEmail(String email);
}
