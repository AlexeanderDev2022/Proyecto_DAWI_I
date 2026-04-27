package com.cibertec.proyectodawi.Model.Deuda;

import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.cibertec.proyectodawi.Model.Socio.Socio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;

    private LocalDate fechaVencimiento;

    private Boolean pagado;
    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "puesto_id", nullable = false)
    private Puesto puesto;
}