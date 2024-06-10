package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.ac.rca.spring_boot_template.enumerations.EPaymentMethod;
import rw.ac.rca.spring_boot_template.enumerations.EPaymentStatus;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;
    @Column()

    private Double amount;
    @Column()

    private LocalDate paymentDate;
    @Column()

    private EPaymentMethod paymentMethod;
    @OneToOne

    private Order order;
    @Column()

    private EPaymentStatus status;




}
