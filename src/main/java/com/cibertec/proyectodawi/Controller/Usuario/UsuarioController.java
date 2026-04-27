package com.cibertec.proyectodawi.Controller.Usuario;

import com.cibertec.proyectodawi.Model.Usuario;
import com.cibertec.proyectodawi.Model.UsuarioLogin;
import com.cibertec.proyectodawi.security.JWTAuthenticationConfig;
import com.cibertec.proyectodawi.services.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final JWTAuthenticationConfig jwtAuthenticationConfig;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        // Retorna la lista real desde el servicio
        return new ResponseEntity<>(usuarioService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/unprotected")
    public ResponseEntity<List<Usuario>> getUnprotectedUsuarios() {
        // Retorna la lista real desde el servicio
        return new ResponseEntity<>(usuarioService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLogin usuarioLogin) {
        Usuario usuario = usuarioService.login(usuarioLogin.getUsuario(), usuarioLogin.getPassword());

        if (usuario == null) {
            throw new UsernameNotFoundException("Credenciales invalidas");
        }

        return ResponseEntity.ok(
                jwtAuthenticationConfig.getJWTToken(
                        usuario.getUsuario(),
                        usuario.getNombres(),
                        usuario.getApellidos()
                )
        );

    }
    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }
}