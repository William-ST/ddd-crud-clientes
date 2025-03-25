package com.example.clientesapi.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para recibir datos de actualización de clientes
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteUpdateRequest {

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(min = 3, max = 100, message = "Los apellidos deben tener entre 3 y 100 caracteres")
    private String apellidos;

    @NotBlank(message = "Los nombres son obligatorios")
    @Size(min = 3, max = 100, message = "Los nombres deben tener entre 3 y 100 caracteres")
    private String nombres;

    @NotBlank(message = "El dni es obligatorio")
    @Size(min = 8, max = 8, message = "El dni debe tener 8 caracteres")
    private String dni;

    @NotBlank(message = "El correo es obligatorio")
    @Size(min = 3, max = 100, message = "El correo debe tener entre 3 y 100 caracteres")
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 7, max = 9, message = "El teléfono debe tener entre 7 y 9 caracteres")
    private String telefono;
}