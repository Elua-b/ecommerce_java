package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class CartItem {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column()

    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column()

    private int quantity;
    @Column()

    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Order order;

}
