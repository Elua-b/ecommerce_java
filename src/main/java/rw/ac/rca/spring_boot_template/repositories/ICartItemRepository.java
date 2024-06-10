package rw.ac.rca.spring_boot_template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.spring_boot_template.models.CartItem;

import java.util.UUID;

public interface ICartItemRepository extends JpaRepository<CartItem, UUID> {


    boolean existsByOrderIdAndProductId(UUID orderId, UUID productId);


}
