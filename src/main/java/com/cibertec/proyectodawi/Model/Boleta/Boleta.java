package com.cibertec.proyectodawi.Model.Boleta;

import com.cibertec.proyectodawi.Model.Deuda.Deuda;
import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.cibertec.proyectodawi.Model.Socio.Socio;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBoleta;

    @Column(nullable = false, unique = true)
    private String serie;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private LocalDateTime fechaPago;

    // RELACIONES CLAVE
    @ManyToOne
    @JoinColumn(name = "id_deuda", nullable = false)
    private Deuda deuda; // Para saber qué deuda se pagó

    @ManyToOne
    @JoinColumn(name = "id_socio")
    private Socio socio; // Para saber qué socio pagó

    @ManyToOne
    @JoinColumn(name = "id_puesto")
    private Puesto puesto; // Para saber de qué puesto es el pago
}