package rw.ac.rca.spring_boot_template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.spring_boot_template.models.Cart;
import rw.ac.rca.spring_boot_template.models.User;

import java.util.Optional;
import java.util.UUID;

public interface ICartRepository extends JpaRepository<Cart, UUID> {
    Optional<User> findByUserId(UUID userId);
}
