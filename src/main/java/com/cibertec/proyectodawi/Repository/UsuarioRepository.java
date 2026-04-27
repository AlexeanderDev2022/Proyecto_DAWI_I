package com.cibertec.proyectodawi.Repository;

import com.cibertec.proyectodawi.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("select a from Usuario a where a.usuario = :username and a.password = :password")
    Usuario findByUsernameAndPassword(String username, String password);
}
