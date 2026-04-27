package com.cibertec.proyectodawi.dto.Deuda.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeudaRequestDto {
    private Double monto;
    private LocalDate fechaVencimiento;
    private Boolean pagado;
    private String motivo;
    private Long socioId;
    private Long puestoId;
}