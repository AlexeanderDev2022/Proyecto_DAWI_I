package com.cibertec.proyectodawi.dto.Socio.Response;

import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.cibertec.proyectodawi.dto.Puesto.response.PuestoResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocioSimpleDTO {
    private Long id;
    private String nombre;
}