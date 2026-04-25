package com.cibertec.proyectodawi.services.Pago;

import com.cibertec.proyectodawi.Model.Boleta;
import com.cibertec.proyectodawi.Repository.IBoletaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class BoletaService {

    private final IBoletaRepository repo;
    public BoletaService(IBoletaRepository repo) {
        this.repo = repo;
    }

    public Boleta registrarPago(Double monto, String concepto) {
        long timestamp = System.currentTimeMillis();
        String serieGenerada = "B001-" + String.format("%06d", timestamp % 1000000);

        Boleta boleta = new Boleta();
        boleta.setMonto(monto);
        boleta.setFechaPago(LocalDateTime.now());
        boleta.setSerie(serieGenerada);
        boleta.setConcepto(concepto);

        return repo.save(boleta);
    }
}