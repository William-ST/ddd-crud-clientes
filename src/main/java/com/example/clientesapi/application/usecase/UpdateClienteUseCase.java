package com.example.clientesapi.application.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Caso de uso para actualizar clientes
 */
@Component
@RequiredArgsConstructor
public class UpdateClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Actualiza un cliente existente
     * @param id ID del cliente a actualizar
     * @param apellidos nuevo apellidos
     * @param nombres nueva nombres
     * @param dni nuevo dni
     * @param correo nuevo correo
     * @param telefono nuevo telefono
     * @return el cliente actualizado
     */
    public Cliente execute(UUID id, String apellidos, String nombres, String dni, String correo, String telefono) {
        return clienteService.actualizarCliente(id, apellidos, nombres, dni, correo, telefono);
    }

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id ID del clientes
     * @param activo nuevo estado
     * @return el cliente actualizado
     */
    public Cliente executeStateUpdate(UUID id, Boolean activo) {
        return clienteService.actualizarEstadoCliente(id, activo);
    }

}