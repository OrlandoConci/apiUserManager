package com.auj.userManager.repositories;

import com.auj.userManager.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/// Interfase encargada de la comunicación con la base de datos.
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    /// funciones integradas en la dependencia JPA

    Boolean existsByEmail(String email); /// Busca un email existente en el repositorio.

    Client findByEmail(String email); ///Busca y devuelve un email en el repositorio.
}

