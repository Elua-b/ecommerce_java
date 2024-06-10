package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.ac.rca.spring_boot_template.enumerations.EOrderStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;

    @Column()

    private LocalDate orderDate;
    @Column()

    private EOrderStatus status;
    @Column()

    private Double totalAmount;
    @ManyToOne
    private User user;
    @OneToMany

    private List<OrderItem> items;
}
