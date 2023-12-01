package com.inclusion.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CalculatorRequest {
    private int x;
    private int y;
    private int n;
}
