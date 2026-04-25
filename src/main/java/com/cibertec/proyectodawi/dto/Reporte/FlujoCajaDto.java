package com.cibertec.proyectodawi.dto.Reporte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlujoCajaDto {
    private Double total;
    private Long operaciones;
    private Double promedio;
}