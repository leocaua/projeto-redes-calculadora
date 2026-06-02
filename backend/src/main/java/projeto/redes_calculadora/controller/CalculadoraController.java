package projeto.redes_calculadora.controller;


import projeto.redes_calculadora.dto.RedeDTO;
import org.springframework.web.bind.annotation.*;
import projeto.redes_calculadora.service.CalculadoraService;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*")
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping("/calcular")
    public RedeDTO calcular(@RequestParam String ip, @RequestParam int cidr) {
        return service.calcular(ip, cidr);
    }
}
