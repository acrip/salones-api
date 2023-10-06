package co.unicauca.sirs.salones.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SalonRequestDTO(@NotBlank @Size(max = 255) String name, @Positive @NotNull Integer capacity, boolean isActive) {
}
