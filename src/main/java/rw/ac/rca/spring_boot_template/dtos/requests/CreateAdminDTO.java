package rw.ac.rca.spring_boot_template.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rw.ac.rca.spring_boot_template.enumerations.EGender;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminDTO {
    @NotBlank(message = "Username is required")
    private String username;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Gender is required")
    private EGender gender;

    @NotBlank(message = "Registration code is required")
    private String registrationCode;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

}
