package com.cibertec.proyectodawi.Repository.Boleta;

import com.cibertec.proyectodawi.Model.Boleta.Boleta;
import com.cibertec.proyectodawi.Model.Pago.Pago;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Long> {

}