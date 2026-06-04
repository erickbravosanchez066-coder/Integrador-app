package com.pizzeria.esperadigital.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre; // Pepperoni, Champiñones, etc.

    @Column(nullable = false)
    private Double precioExtra;

    private String imagenUrl;
}
