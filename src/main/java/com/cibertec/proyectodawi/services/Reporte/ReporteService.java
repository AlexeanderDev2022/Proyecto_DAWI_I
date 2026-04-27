package com.cibertec.proyectodawi.services.Reporte;

import com.cibertec.proyectodawi.Repository.Deuda.DeudaRepository;
import com.cibertec.proyectodawi.Repository.Pago.PagoRepository;

import com.cibertec.proyectodawi.dto.Reporte.request.DeudaSocioDto;
import com.cibertec.proyectodawi.dto.Reporte.response.DeudorCriticoDto;
import com.cibertec.proyectodawi.dto.Reporte.response.FlujoCajaDto;
import com.cibertec.proyectodawi.dto.Reporte.response.TopSocioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final PagoRepository pagoRepository;
    private final DeudaRepository deudaRepository;

    // 1. Flujo de caja diaria
    public FlujoCajaDto flujoDiario(LocalDate fecha){
        Double total = pagoRepository.totalPorDia(fecha);
        Long cantidad = pagoRepository.cantidadPorDia(fecha);

        if(total == null) total = 0.0;
        if(cantidad == null) cantidad = 0L;

        double promedio = (cantidad != 0) ? total / cantidad : 0;

        return new FlujoCajaDto(total, cantidad, promedio);
    }

    // 2. Deuda por socio
    public List<DeudaSocioDto> deudaPorSocio(){
        return deudaRepository.deudaPorSocio()
                .stream()
                .map(obj -> new DeudaSocioDto(
                        (String) obj[0],
                        (Double) obj[1]
                ))
                .toList();
    }

    // 3. Deudores críticos
    public List<DeudorCriticoDto> deudoresCriticos(Double monto){
        return deudaRepository.deudoresCriticos(monto)
                .stream()
                .map(d -> new DeudorCriticoDto(
                        d.getSocio().getNombre(),
                        d.getMonto(),
                        d.getFechaVencimiento().isBefore(LocalDate.now())
                                ? "VENCIDO"
                                : "MONTO ALTO"
                ))
                .toList();
    }

    // 4. Top socios
    public List<TopSocioDto> topSocios() {
        return pagoRepository.topSocios()
                .stream()
                .map(obj -> new TopSocioDto(
                        (String) obj[0],
                        ((Number) obj[1]).doubleValue()
                ))
                .toList();
    }
}