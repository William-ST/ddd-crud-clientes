package com.example.clientesapi.infrastructure.rest.controller;

import com.example.clientesapi.application.usecase.CreateClienteUseCase;
import com.example.clientesapi.application.usecase.DeleteClienteUseCase;
import com.example.clientesapi.application.usecase.GetClienteUseCase;
import com.example.clientesapi.application.usecase.UpdateClienteUseCase;
import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.infrastructure.persistence.mapper.ClienteMapper;
import com.example.clientesapi.infrastructure.rest.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para operaciones de Clientes
 */
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final GetClienteUseCase getClienteUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;
    private final DeleteClienteUseCase deleteClienteUseCase;
    private final ClienteMapper mapper;

    /**
     * Crea un nuevo cliente
     */
    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = mapper.toDomain(request);
        Cliente creado = createClienteUseCase.execute(cliente);
        return new ResponseEntity<>(mapper.toResponse(creado), HttpStatus.CREATED);
    }

    /**
     * Obtiene un cliente por su ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtenerCliente(@PathVariable UUID id) {
        Cliente cliente = getClienteUseCase.executeById(id);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene un cliente por su código
     */
    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClienteResponse> obtenerClientePorDni(@PathVariable String dni) {
        Cliente cliente = getClienteUseCase.executeByDni(dni);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }

    /**
     * Obtiene todos los clientes
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
        List<Cliente> clientes = getClienteUseCase.executeAll();
        return ResponseEntity.ok(mapper.toResponseList(clientes));
    }

    /**
     * Actualiza un cliente existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizarCliente(
            @PathVariable UUID id,
            @Valid @RequestBody ClienteUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.execute(
                id,
                request.getApellidos(),
                request.getNombres(),
                request.getDni(),
                request.getCorreo(),
                request.getTelefono()
        );

        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Actualiza el estado de un cliente
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<ClienteResponse> actualizarEstadoCliente(
            @PathVariable UUID id,
            @Valid @RequestBody EstadoUpdateRequest request) {

        Cliente actualizado = updateClienteUseCase.executeStateUpdate(id, request.getActivo());
        return ResponseEntity.ok(mapper.toResponse(actualizado));
    }

    /**
     * Elimina un cliente
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable UUID id) {
        deleteClienteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}