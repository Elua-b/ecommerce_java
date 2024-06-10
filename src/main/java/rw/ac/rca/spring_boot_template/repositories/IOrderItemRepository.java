package rw.ac.rca.spring_boot_template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.spring_boot_template.models.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long>{

}
