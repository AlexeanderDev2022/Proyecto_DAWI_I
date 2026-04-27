package com.cibertec.proyectodawi.dto.Boleta.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoletaRequestDto {

    private Long idDeuda;    // A QUÉ deuda le estamos aplicando este pago

}