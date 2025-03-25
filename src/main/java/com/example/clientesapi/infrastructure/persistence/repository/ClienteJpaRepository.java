package com.example.clientesapi.infrastructure.persistence.repository;

import com.example.clientesapi.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio JPA para la entidad ClienteEntity
 */
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

    /**
     * Busca un cliente por su dni
     */
    Optional<ClienteEntity> findByDni(String dni);

    /**
     * Verifica si existe un cliente con el dni proporcionado
     */
    boolean existsByDni(String dni);
}