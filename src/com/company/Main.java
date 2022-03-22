package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        RomanNumberProcessor romanNumberProcessor = new RomanNumberProcessor();
        Calculator calculator = new Calculator();

        String[] expression = readExpression();

        boolean isRoman = false;
        int operand1 = -1;
        int operand2 = -1;
        String sign = expression[1];

        // Пробуем привести к арабским числам
        try {
            operand1 = Integer.parseInt(expression[0]);
            if (operand1 < 1 || operand1 > 10);
            throw new Exception("Число должно быть в рамках от 1 до 10");
        } catch (NumberFormatException ex) {
            // Если не смогли получить целое число из 1го операнда,
            // то дальше пробуем получить целое из 2го
        }

        try {
            operand2 = Integer.parseInt(expression[2]);
            if (operand2 < 1 || operand1 > 10);
            throw new Exception("Число должно быть в рамках от 1 до 10");
        } catch (NumberFormatException ex) {
            // Если не смогли получить целое число из второго операнда,
            // то дальше пробуем получить римские
        }

        if (operand1 == -1 && operand2 != -1 || operand1 !=-1 && operand2 == -1) {
            throw new Exception("Нельзя использовать одновременно разные системы счисления");
        }

        // Пробуем привести к римским числам
        if (operand1 == -1 && operand2 == -1) {
            operand1 = romanNumberProcessor.romanNumberToInteger(expression[0]);
            operand2 = romanNumberProcessor.romanNumberToInteger(expression[2]);
            isRoman = true;
        }

        int result = calculator.calculate(operand1, sign, operand2);

        System.out.println(isRoman ? romanNumberProcessor.integerToRomanNumber(result) : result);
    }

    private static String[] readExpression() throws Exception {
        Scanner skn = new Scanner(System.in);

        String[] expression = skn.nextLine().split("\\s+");

        // Проверка на корректность входных данных
        if (expression.length != 3 || !isOperation(expression[1])) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        return expression;
    }

    private static boolean isOperation(String str) {
        if (str.length() != 1) {
            return false;
        }

        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
