package com.cibertec.proyectodawi.dto.Reporte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopSocioDto {
    private String socio;
    private Double totalPagado;
}