package rw.ac.rca.spring_boot_template.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateCartDTO {
    private UUID userId;

}
