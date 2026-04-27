package com.cibertec.proyectodawi.dto.Puesto.request;

import com.cibertec.proyectodawi.Model.Socio.Socio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuestoRequestDto {
    private Long socioId;
    private Integer version;
}
