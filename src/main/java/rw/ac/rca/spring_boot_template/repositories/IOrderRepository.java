package rw.ac.rca.spring_boot_template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.spring_boot_template.models.Order;

import java.util.UUID;

public interface IOrderRepository extends JpaRepository<Order, UUID> {

}
