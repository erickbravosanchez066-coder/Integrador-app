package com.pizzeria.esperadigital.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cola_virtual")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColaVirtual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "posicion_actual", nullable = false)
    private Integer posicionActual;

    @Column(name = "tiempo_espera_estimado", nullable = false)
    private Integer tiempoEsperaEstimado; // en minutos

    @Column(nullable = false)
    private String estado; // ESPERANDO, PROXIMO_TURNO, MESA_LISTA

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @PrePersist
    public void prePersist() {
        this.fechaIngreso = LocalDateTime.now();
    }
}
