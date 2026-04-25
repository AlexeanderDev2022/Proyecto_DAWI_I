package com.cibertec.poyectodawi.Repository.Deuda;

import com.cibertec.poyectodawi.Model.Deuda.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeudaRepository extends JpaRepository<Deuda, Long> {

    @Query("SELECT d.socio.nombre, SUM(d.monto) " +
            "FROM Deuda d WHERE d.pagado = false GROUP BY d.socio.nombre")
    List<Object[]> deudaPorSocio();

    @Query("SELECT d FROM Deuda d WHERE d.pagado = false AND " +
            "(d.monto > :monto OR d.fechaVencimiento < CURRENT_DATE)")
    List<Deuda> deudoresCriticos(Double monto);
}