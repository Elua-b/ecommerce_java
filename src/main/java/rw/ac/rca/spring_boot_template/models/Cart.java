package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rw.ac.rca.spring_boot_template.enumerations.EOrderStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column()
    private LocalDate dateCreated;
    @Column()

    private double totalAmount;
    @Column()

    private EOrderStatus status;



    //relationship
    @OneToOne
    private User user;
    @OneToMany
    private List<CartItem> items;


}
