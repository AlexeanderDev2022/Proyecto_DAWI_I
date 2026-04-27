package com.cibertec.proyectodawi.dto.Deuda.Response;

import com.cibertec.proyectodawi.dto.Puesto.response.PuestoSimpleDto;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaResponseDto {
    private Long id;
    private Double monto;
    private LocalDate fechaVencimiento;
    private Boolean pagado;
    private String motivo;

    private SocioSimpleDTO socio;
    private PuestoSimpleDto puesto;
}