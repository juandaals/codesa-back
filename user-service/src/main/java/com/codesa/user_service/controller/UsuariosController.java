package com.codesa.user_service.controller;

import com.codesa.user_service.model.Usuario;
import com.codesa.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {
    @Autowired
    private UserService usuarioService;
    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }


    @GetMapping("{document}")
    public ResponseEntity<Usuario> getUserByDocument(@PathVariable String document) {
        return usuarioService.getUserByDocument(document);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario newUser = usuarioService.createUser(usuario);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.updateUser(id, usuarioDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return usuarioService.deleteUser(id);
    }

}
