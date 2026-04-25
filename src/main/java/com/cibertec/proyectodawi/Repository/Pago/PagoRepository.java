package com.cibertec.poyectodawi.Repository.Pago;

import com.cibertec.poyectodawi.Model.Pago.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("SELECT SUM(p.monto) FROM Pago p WHERE p.fecha = :fecha")
    Double totalPorDia(LocalDate fecha);

    @Query("SELECT COUNT(p) FROM Pago p WHERE p.fecha = :fecha")
    Long cantidadPorDia(LocalDate fecha);

    @Query("SELECT p.socio.nombre, SUM(p.monto) " +
            "FROM Pago p GROUP BY p.socio.nombre ORDER BY SUM(p.monto) DESC")
    List<Object[]> topSocios();
}