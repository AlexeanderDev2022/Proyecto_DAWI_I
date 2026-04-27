package com.cibertec.proyectodawi.services.Usuario;

import com.cibertec.proyectodawi.Model.Usuario;
import com.cibertec.proyectodawi.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List; // Importante agregar este import

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // MÉTODO QUE DEBES AGREGAR
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario login(String login, String password) {
        return usuarioRepository.findByUsernameAndPassword(login, password);
    }
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}