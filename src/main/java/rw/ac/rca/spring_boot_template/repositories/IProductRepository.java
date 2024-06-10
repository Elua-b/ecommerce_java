package rw.ac.rca.spring_boot_template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.ac.rca.spring_boot_template.models.Product;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository  extends JpaRepository<Product, UUID> {

    Optional<Product> findByName(String name);


}
