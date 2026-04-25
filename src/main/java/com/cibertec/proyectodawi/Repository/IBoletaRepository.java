package com.cibertec.poyectodawi.repository;

import com.cibertec.poyectodawi.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {

}