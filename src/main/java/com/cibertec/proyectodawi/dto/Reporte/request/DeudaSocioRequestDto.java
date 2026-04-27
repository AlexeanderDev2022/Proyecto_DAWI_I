package com.cibertec.proyectodawi.dto.Reporte.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaSocioRequestDto {
    private String socio;
    private Double totalDeuda;
}