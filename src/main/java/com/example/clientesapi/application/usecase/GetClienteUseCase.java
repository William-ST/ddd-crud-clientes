package com.example.clientesapi.application.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Caso de uso para obtener clientes
 */
@Component
@RequiredArgsConstructor
public class GetClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     */
    public Cliente executeById(UUID id) {
        return clienteService.obtenerClientePorId(id);
    }

    /**
     * Obtiene un cliente por su código
     * @param dni el dni del cliente
     * @return el cliente encontrado
     */
    public Cliente executeByDni(String dni) {
        return clienteService.obtenerClientePorDni(dni);
    }

    /**
     * Obtiene todos los clientes
     * @return lista de todos los clientes
     */
    public List<Cliente> executeAll() {
        return clienteService.obtenerTodosLosClientes();
    }

}