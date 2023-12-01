package com.inclusion.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int calculate(int x, int y, int n) {
        int maxK = (n / x) * x;
        return (maxK + y <= n) ? maxK + y : maxK - (x - y);
    }
}
