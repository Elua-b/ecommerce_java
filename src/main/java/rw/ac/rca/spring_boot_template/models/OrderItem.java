package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;
    @OneToOne

    private Product product;
    @Column()

    private int quantity;
    @Column()

    private double price;

    @ManyToOne
    private Order order;

}
