package com.example.clientesapi.application.usecase;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Caso de uso para crear un cliente
 */
@Component
@RequiredArgsConstructor
public class CreateClienteUseCase {

    private final ClienteService clienteService;

    /**
     * Ejecuta el caso de uso
     * @param cliente el cliente a crear
     * @return el cliente creado
     */
    public Cliente execute(Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
}