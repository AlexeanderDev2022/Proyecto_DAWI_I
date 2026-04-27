package com.cibertec.proyectodawi.dto.Boleta.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BoletaResponseDto {

    private int idBoleta;
    private String serie;
    private Double monto;
    private LocalDateTime fechaPago;
    private String motivo;
    private String nombreSocio;
    private Long idPuesto;
    private Long idDeuda;

}