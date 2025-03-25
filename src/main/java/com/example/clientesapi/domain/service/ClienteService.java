package com.example.clientesapi.domain.service;

import com.example.clientesapi.domain.exception.ClienteNotFoundException;
import com.example.clientesapi.domain.model.Cliente;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de dominio para la lógica de negocio relacionada con Clientes
 */
public interface ClienteService {

    /**
     * Crea un nuevo cliente
     * @param cliente el cliente a crear
     * @return el cliente creado
     */
    Cliente crearCliente(Cliente cliente);

    /**
     * Obtiene un cliente por su ID
     * @param id el ID del cliente
     * @return el cliente encontrado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorId(UUID id);

    /**
     * Obtiene un cliente por su código
     * @param dni el dni del cliente
     * @return el cliente encontrado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente obtenerClientePorDni(String dni);

    /**
     * Obtiene todos los clientes
     * @return lista de clientes
     */
    List<Cliente> obtenerTodosLosClientes();

    /**
     * Actualiza un cliente existente
     * @param id el ID del cliente a actualizar
     * @param apellidos nuevo apellidos
     * @param nombres nuevo nombres
     * @param dni nuevo dni
     * @param correo nuevo correo
     * @param telefono nuevo telefono
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarCliente(UUID id, String apellidos, String nombres, String dni, String correo, String telefono);

    /**
     * Actualiza el estado (activo/inactivo) de un cliente
     * @param id el ID del cliente
     * @param activo el nuevo estado
     * @return el cliente actualizado
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    Cliente actualizarEstadoCliente(UUID id, Boolean activo);

    /**
     * Elimina un cliente por su ID
     * @param id el ID del cliente a eliminar
     * @throws ClienteNotFoundException si no se encuentra el cliente
     */
    void eliminarCliente(UUID id);
}