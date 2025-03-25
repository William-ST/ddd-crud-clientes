package com.example.clientesapi.domain.repository;

import com.example.clientesapi.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interfaz del repositorio de dominio para Clientes.
 * Define las operaciones de persistencia sin detalles de implementación.
 */
public interface ClienteRepository {

    /**
     * Guarda un nuevo cliente o actualiza uno existente
     * @param cliente el cliente a guardar
     * @return el cliente guardado
     */
    Cliente save(Cliente cliente);

    /**
     * Busca un cliente por su ID
     * @param id el ID del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findById(UUID id);

    /**
     * Busca un cliente por su dni
     * @param dni el dni del cliente
     * @return un Optional con el cliente si existe
     */
    Optional<Cliente> findByDni(String dni);

    /**
     * Obtiene todos los clientes
     * @return lista de clientes
     */
    List<Cliente> findAll();

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     */
    void deleteById(UUID id);
    /**
     * Verifica si existe un cliente con el dni proporcionado
     * @param dni el dni a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsByDni(String dni);

}