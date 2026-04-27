package com.cibertec.proyectodawi.services.Pago;

import com.cibertec.proyectodawi.Model.Boleta.Boleta;
import com.cibertec.proyectodawi.Model.Deuda.Deuda;
import com.cibertec.proyectodawi.Repository.Boleta.IBoletaRepository;
import com.cibertec.proyectodawi.Repository.Deuda.DeudaRepository;

import com.cibertec.proyectodawi.dto.Boleta.Request.BoletaRequestDto;
import com.cibertec.proyectodawi.dto.Boleta.Response.BoletaResponseDto;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoletaService {

    private final IBoletaRepository repo;
    private final DeudaRepository deudaRepo;

    @Transactional
    public BoletaResponseDto registrarPago(BoletaRequestDto request) {

        // 1. Obtener ID desde DTO
        Long idDeuda = request.getIdDeuda();

        // 2. Buscar deuda
        Deuda deuda = deudaRepo.findById(idDeuda)
                .orElseThrow(() -> new RuntimeException("No existe la deuda con ID: " + idDeuda));

        // 3. Validar
        if (deuda.getPagado()) {
            throw new RuntimeException("La deuda ya está pagada");
        }

        // 4. Generar serie
        String serie = generarSerie();

        // 5. Crear boleta
        Boleta boleta = new Boleta();
        boleta.setSerie(serie);
        boleta.setMonto(deuda.getMonto());
        boleta.setFechaPago(LocalDateTime.now());

        // 6. Relaciones
        boleta.setDeuda(deuda);
        boleta.setSocio(deuda.getSocio());
        boleta.setPuesto(deuda.getPuesto());

        // 7. Actualizar deuda
        deuda.setPagado(true);
        deudaRepo.save(deuda);

        // 8. Guardar boleta
        Boleta boletaGuardada = repo.save(boleta);

        // 9. Convertir a DTO 🔥
        return new BoletaResponseDto(
                boletaGuardada.getIdBoleta(),
                boletaGuardada.getSerie(),
                boletaGuardada.getMonto(),
                boletaGuardada.getFechaPago(),
                deuda.getMotivo() != null ? deuda.getMotivo() : null,
                deuda.getSocio() != null ? deuda.getSocio().getNombre() : null,
                deuda.getPuesto() != null ? deuda.getPuesto().getId() : null,
                deuda.getId()
        );
    }

    private String generarSerie() {
        long count = repo.count() + 1;
        return String.format("B001-%06d", count);
    }
}