package controller;


import dto.RedeDTO;
import org.springframework.web.bind.annotation.*;
import service.CalculadoraService;

@RestController
@RequestMapping
@CrossOrigin
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @GetMapping
    public RedeDTO calcular(@RequestParam String ip, @RequestParam int cidr) {
        return service.calcular(ip, cidr);
    }
}
