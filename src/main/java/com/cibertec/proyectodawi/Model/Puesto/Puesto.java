    package com.cibertec.proyectodawi.Model.Puesto;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity

    public class Puesto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(columnDefinition = "TEXT DEFAULT 'Asociación'")
        private String dueno;
        @Version
        private Integer version;


    }
