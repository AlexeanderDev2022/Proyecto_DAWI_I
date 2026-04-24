package com.cibertec.poyectodawi.Model.Deuda;

import com.cibertec.poyectodawi.Model.Puesto.Puesto;
import com.cibertec.poyectodawi.Model.Socio.Socio;
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

    @ManyToOne
    private Socio socio;

    @ManyToOne
    private Puesto puesto;
}