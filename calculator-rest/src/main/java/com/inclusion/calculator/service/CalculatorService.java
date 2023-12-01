package com.inclusion.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int realizarOperacion(int x, int y, int n) {
        // Calcula la cantidad de veces que x cabe en n y multiplica por x
        int maxK = (n / x) * x;

        // Resta y a maxK si es menor que n, de lo contrario, devuelve maxK
        return (maxK + y <= n) ? maxK + y : maxK - (x - y);
    }
}
