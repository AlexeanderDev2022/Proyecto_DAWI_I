package com.cibertec.poyectodawi.Repository.Puesto;

import com.cibertec.poyectodawi.Model.Puesto.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   PuestoRepository extends JpaRepository <Puesto,Long> {
}
