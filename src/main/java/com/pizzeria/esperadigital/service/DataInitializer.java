package com.pizzeria.esperadigital.service;

import com.pizzeria.esperadigital.entity.Ingrediente;
import com.pizzeria.esperadigital.entity.Mesa;
import com.pizzeria.esperadigital.entity.Pizza;
import com.pizzeria.esperadigital.repository.IngredienteRepository;
import com.pizzeria.esperadigital.repository.MesaRepository;
import com.pizzeria.esperadigital.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ingredienteRepository.count() == 0) {
            ingredienteRepository.save(Ingrediente.builder().nombre("Pepperoni").precioExtra(2.50).imagenUrl("https://cdn-icons-png.flaticon.com/512/3661/3661605.png").build());
            ingredienteRepository.save(Ingrediente.builder().nombre("Queso extra").precioExtra(1.50).imagenUrl("https://cdn-icons-png.flaticon.com/512/3014/3014526.png").build());
            ingredienteRepository.save(Ingrediente.builder().nombre("Champiñones").precioExtra(2.00).imagenUrl("https://cdn-icons-png.flaticon.com/512/2821/2821817.png").build());
            ingredienteRepository.save(Ingrediente.builder().nombre("Aceitunas").precioExtra(1.00).imagenUrl("https://cdn-icons-png.flaticon.com/512/1155/1155255.png").build());
            ingredienteRepository.save(Ingrediente.builder().nombre("Tocino").precioExtra(3.00).imagenUrl("https://cdn-icons-png.flaticon.com/512/3014/3014539.png").build());
            ingredienteRepository.save(Ingrediente.builder().nombre("Cebolla").precioExtra(1.00).imagenUrl("https://cdn-icons-png.flaticon.com/512/7234/7234479.png").build());
        }

        if (mesaRepository.count() == 0) {
            mesaRepository.save(Mesa.builder().numero("01").ubicacion("INTERIOR").capacidad(4).disponible(true).build());
            mesaRepository.save(Mesa.builder().numero("02").ubicacion("INTERIOR").capacidad(2).disponible(true).build());
            mesaRepository.save(Mesa.builder().numero("03").ubicacion("TERRAZA").capacidad(4).disponible(true).build());
            mesaRepository.save(Mesa.builder().numero("04").ubicacion("TERRAZA").capacidad(6).disponible(true).build());
        }

        if (pizzaRepository.count() == 0) {
            pizzaRepository.save(Pizza.builder().tamano("PERSONAL").tipoMasa("FINA").precioBase(8.00).build());
            pizzaRepository.save(Pizza.builder().tamano("MEDIANA").tipoMasa("GRUESA").precioBase(14.00).build());
            pizzaRepository.save(Pizza.builder().tamano("FAMILIAR").tipoMasa("ARTESANAL").precioBase(20.00).build());
        }
    }
}
