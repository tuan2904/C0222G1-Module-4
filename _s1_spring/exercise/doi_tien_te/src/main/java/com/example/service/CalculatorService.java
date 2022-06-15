package com.example.service;

public class CalculatorService implements ICalculatorService{
    @Override
    public Double calculator(double input) {
        return input * 22000;
    }
}
