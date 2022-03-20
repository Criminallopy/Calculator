package com.company;

public class Calculator {

    public int calculate(int operand1, String sign, int operand2) {
        return switch (sign) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> 0;
        };
    }
}
