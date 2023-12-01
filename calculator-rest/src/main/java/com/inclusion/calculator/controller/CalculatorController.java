package com.inclusion.calculator.controller;

import com.inclusion.calculator.model.CalculatorRequest;
import com.inclusion.calculator.model.CalculatorResponse;
import com.inclusion.calculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
@Slf4j
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorServiceService;

    @GetMapping("/sumar-y-multiplicar")
    public CalculatorResponse sumaYMultiplica(@RequestParam int x, @RequestParam int y, @RequestParam int n) {
        int resultado = calculatorServiceService.realizarOperacion(x, y, n);
        return new CalculatorResponse(resultado);
    }

    @PostMapping("/sumar-y-multiplicar")
    public CalculatorResponse sumaYMultiplica(@RequestBody CalculatorRequest request) {
        int resultado = calculatorServiceService.realizarOperacion(request.getX(), request.getY(), request.getN());
        return new CalculatorResponse(resultado);
    }
}
