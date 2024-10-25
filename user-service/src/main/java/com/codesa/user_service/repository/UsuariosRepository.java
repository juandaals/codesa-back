package com.codesa.user_service.repository;

import com.codesa.user_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDocument(String document);

}
