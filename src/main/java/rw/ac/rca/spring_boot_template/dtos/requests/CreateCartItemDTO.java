package rw.ac.rca.spring_boot_template.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartItemDTO {
    private UUID productId;
    private int quantity;
    private double price;
    private UUID orderId;

}
