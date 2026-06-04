package com.pizzeria.esperadigital.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pizzas_base")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tamano; // PERSONAL, MEDIANA, FAMILIAR

    @Column(nullable = false)
    private String tipoMasa; // FINA, GRUESA, ARTESANAL

    @Column(nullable = false)
    private Double precioBase;
}
