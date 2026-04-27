    package com.cibertec.proyectodawi.Model.Puesto;

    import com.cibertec.proyectodawi.Model.Socio.Socio;
    import com.fasterxml.jackson.annotation.JsonBackReference;
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

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "socio_id", nullable = true)
        private Socio socio;
        @Version
        private Integer version;


    }
