package danilovolles.productms.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductDTO {

    @NotEmpty
    @NotNull
    @NotBlank
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 50)
    private String description;

    @NotEmpty
    @NotNull
    @Positive
    private double price;

    @NotEmpty
    @NotNull
    private boolean available;
}
