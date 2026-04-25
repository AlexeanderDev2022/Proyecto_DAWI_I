package com.cibertec.proyectodawi.Repository;

import com.cibertec.proyectodawi.Model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {

}