package com.cibertec.poyectodawi.dto.Reporte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaSocioDto {
    private String socio;
    private Double totalDeuda;
}