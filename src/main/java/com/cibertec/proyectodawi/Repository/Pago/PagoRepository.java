package com.cibertec.proyectodawi.Repository.Pago;

import com.cibertec.proyectodawi.Model.Pago.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("SELECT SUM(p.deuda.monto) FROM Pago p WHERE p.fechaPago = :fecha")
    Double totalPorDia(LocalDate fecha);

    @Query("SELECT COUNT(p) FROM Pago p WHERE p.fechaPago = :fecha")
    Long cantidadPorDia(LocalDate fecha);

    @Query("SELECT p.deuda.socio.nombre, SUM(p.deuda.monto) " +
            "FROM Pago p " +
            "WHERE p.deuda.pagado = true " +
            "GROUP BY p.deuda.socio.nombre " +
            "ORDER BY SUM(p.deuda.monto) DESC")
    List<Object[]> topSocios();
}