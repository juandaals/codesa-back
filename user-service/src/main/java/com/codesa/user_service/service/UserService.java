package com.codesa.user_service.service;

import com.codesa.user_service.model.Usuario;
import com.codesa.user_service.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//anotations
@Service
public class UserService {
    @Autowired                      //variable
    private UsuariosRepository usersRepository;

    public List<Usuario> getAllUsers() {
        return usersRepository.findAll();
    }

    public ResponseEntity<Usuario> getUserByDocument(String document) {
        Optional<Usuario> usuario = usersRepository.findByDocument(document);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Usuario createUser(Usuario usuario) {
        return usersRepository.save(usuario);
    }

    public ResponseEntity<Usuario> updateUser(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuario = usersRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario existingUsuario = usuario.get();
            existingUsuario.setNombre(usuarioDetails.getNombre());
            existingUsuario.setApellido(usuarioDetails.getApellido());
            existingUsuario.setEmail(usuarioDetails.getEmail());
            existingUsuario.setTelefono(usuarioDetails.getTelefono());
            Usuario updatedUsuario = usersRepository.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

