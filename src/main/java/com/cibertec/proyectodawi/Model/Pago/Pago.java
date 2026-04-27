package com.cibertec.proyectodawi.Model.Pago;

import com.cibertec.proyectodawi.Model.Deuda.Deuda;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoleta;

    private String serie;

    private LocalDateTime fechaPago;

    @ManyToOne
    @JoinColumn(name = "id_deuda")
    private Deuda deuda; // <--- Toda la info (socio, puesto, concepto) ya está aquí
}