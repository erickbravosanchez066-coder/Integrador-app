package com.pizzeria.esperadigital.controller;

import com.pizzeria.esperadigital.repository.IngredienteRepository;
import com.pizzeria.esperadigital.repository.MesaRepository;
import com.pizzeria.esperadigital.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    // 1. Pantalla Bienvenida QR
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 2. Cola Virtual
    @GetMapping("/cola")
    public String cola(Model model) {
        model.addAttribute("posicion", 3); // Simulación
        return "cola";
    }

    // 3. Selección de Mesa
    @GetMapping("/mesas")
    public String mesas(Model model) {
        model.addAttribute("mesas", mesaRepository.findByDisponibleTrue());
        return "mesas";
    }

    // 4. Personalización de Pizza
    @GetMapping("/personalizar")
    public String personalizar(Model model) {
        model.addAttribute("ingredientes", ingredienteRepository.findAll());
        return "personalizar";
    }

    // 5. Confirmación de Pedido
    @PostMapping("/confirmar")
    public String confirmar(Model model) {
        // Lógica simulada de creación de pedido
        return "redirect:/ticket";
    }

    @GetMapping("/ticket")
    public String ticket(Model model) {
        return "ticket";
    }

    // 6. Dashboard Cocina
    @GetMapping("/cocina")
    public String cocina(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "cocina";
    }

    // 7. Dashboard Administrador
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("totalPedidos", pedidoRepository.count());
        return "admin";
    }
}
