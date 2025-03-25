package com.example.clientesapi.infrastructure.persistence.mapper;

import com.example.clientesapi.domain.model.Cliente;
import com.example.clientesapi.infrastructure.persistence.entity.ClienteEntity;
import com.example.clientesapi.infrastructure.rest.dto.ClienteRequest;
import com.example.clientesapi.infrastructure.rest.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Mapper para convertir entre las diferentes representaciones de Cliente
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    /**
     * Convierte de ClienteEntity a Cliente (dominio)
     */
    Cliente toDomain(ClienteEntity entity);

    /**
     * Convierte de Cliente (dominio) a ClienteEntity
     */
    ClienteEntity toEntity(Cliente domain);

    /**
     * Convierte de ClienteRequest a Cliente (dominio)
     */
    @Mapping(target = "id", expression = "java(generarId())")
    @Mapping(target = "activo", constant = "true")
    @Mapping(target = "fechaCreacion", expression = "java(obtenerFechaActual())")
    @Mapping(target = "fechaActualizacion", expression = "java(obtenerFechaActual())")
    Cliente toDomain(ClienteRequest request);

    /**
     * Convierte de Cliente (dominio) a ClienteResponse
     */
    ClienteResponse toResponse(Cliente domain);

    /**
     * Convierte una lista de Clientes (dominio) a lista de ClienteResponse
     */
    List<ClienteResponse> toResponseList(List<Cliente> domainList);

    /**
     * Genera un UUID para nuevos clientes
     */
    @Named("generarId")
    default UUID generarId() {
        return UUID.randomUUID();
    }

    /**
     * Obtiene la fecha actual para registros nuevos
     */
    @Named("obtenerFechaActual")
    default LocalDateTime obtenerFechaActual() {
        return LocalDateTime.now();
    }
}