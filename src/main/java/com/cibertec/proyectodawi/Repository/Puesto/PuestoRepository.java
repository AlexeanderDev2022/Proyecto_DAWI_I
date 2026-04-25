package com.cibertec.proyectodawi.Repository.Puesto;

import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   PuestoRepository extends JpaRepository <Puesto,Long> {
}
