package com.cibertec.proyectodawi.dto.Puesto.response;

import com.cibertec.proyectodawi.dto.Socio.Response.SocioResponseDto;
import com.cibertec.proyectodawi.dto.Socio.Response.SocioSimpleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuestoResponseDto {

    private Long id;
    private Integer version;
    private SocioSimpleDTO socio;

}