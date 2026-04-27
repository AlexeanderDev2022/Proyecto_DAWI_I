package com.cibertec.proyectodawi.dto.Reporte.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlujoCajaRequestDto {
    private Double total;
    private Long operaciones;
    private Double promedio;
}