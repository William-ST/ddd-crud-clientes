package com.example.clientesapi.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad de dominio para representar un Cliente.
 * Esta clase sigue los principios de inmutabilidad de DDD.
 */
@Getter
@ToString
@Builder
public class Cliente {
    private final UUID id;
    private final String apellidos;
    private final String nombres;
    private final String dni;
    private final String correo;
    private final String telefono;
    private final Boolean activo;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaActualizacion;

    /**
     * Método para actualizar un cliente con nuevos valores
     */
    public Cliente actualizar(String apellidos, String nombres, String dni, String correo, String telefono) {
        return Cliente.builder()
                .id(this.id)
                .apellidos(apellidos)
                .nombres(nombres)
                .dni(dni)
                .correo(correo)
                .telefono(telefono)
                .activo(this.activo)
                .fechaCreacion(this.fechaCreacion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    /**
     * Método para cambiar el estado activo del cliente
     */
    public Cliente cambiarEstado(Boolean activo) {
        return Cliente.builder()
                .id(this.id)
                .apellidos(this.apellidos)
                .nombres(this.nombres)
                .dni(this.dni)
                .correo(this.correo)
                .telefono(this.telefono)
                .activo(activo)
                .fechaCreacion(this.fechaCreacion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

}