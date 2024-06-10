package rw.ac.rca.spring_boot_template.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column()
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column()
    private String description;

    @Column()
    private double price;

    @Column()
    private String imageUrl;

    @Column()
    private String category;

    @Column()
    private LocalDate dateCreated;

    @Column()
    private LocalDate lastUpdated;


}
