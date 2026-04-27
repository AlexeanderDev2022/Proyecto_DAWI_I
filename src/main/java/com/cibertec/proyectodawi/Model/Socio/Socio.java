package com.cibertec.proyectodawi.Model.Socio;

import com.cibertec.proyectodawi.Model.Puesto.Puesto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @JsonBackReference
    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)

    private List<Puesto> puestos;
}