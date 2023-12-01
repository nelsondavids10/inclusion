package com.inclusion.calculator.service.impl;

import com.inclusion.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(int x, int y, int n) {
        int maxK = (n / x) * x;
        return (maxK + y <= n) ? maxK + y : maxK - (x - y);
    }
}
