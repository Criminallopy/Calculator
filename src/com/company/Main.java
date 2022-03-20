package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<String, Integer> romanToInt = new HashMap<>();

    public static void main(String[] args) throws Exception {
        initRomanToInt();
        Scanner skn = new Scanner(System.in);

        String[] expression = skn.nextLine().split("\\s+");

        // Проверка на корректность входных данных
        if (expression.length != 3 || !(expression[1].length() == 1) || !isOperation(expression[1])) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        boolean isRoman = false;
        int a = -1;
        int b = -1;

        // Пробуем привести к арабским числам
        try {
            a = Integer.parseInt(expression[0]);
            b = Integer.parseInt(expression[2]);
        } catch (NumberFormatException ex) {}

        // Пробуем привести к римским числам
        if (a == -1 && b == -1) {
            try {
                a = romanToInt.get(expression[0]);
            } catch (Exception exception) {
                throw new Exception("Invalid input data");
            }

            try {
                b = romanToInt.get(expression[2]);
            } catch (Exception exception) {
                throw new Exception("Invalid input data");
            }

            isRoman = true;
        }

        int res;
        switch (expression[1]) {
            case "+" : res = a + b; break;
            case "-" : res = a - b; break;
            case "*" : res = a * b; break;
            case "/" : res = a / b; break;
            default : res = 0;
        }

        System.out.println(isRoman ? integerToRomanNumber(res) : res);
    }

    private static void initRomanToInt() {
        romanToInt.put("I", 1);
        romanToInt.put("II", 2);
        romanToInt.put("III", 3);
        romanToInt.put("IV", 4);
        romanToInt.put("V", 5);
        romanToInt.put("VI", 6);
        romanToInt.put("VII", 7);
        romanToInt.put("VIII", 8);
        romanToInt.put("IX", 9);
        romanToInt.put("X", 10);
    }

    private static boolean isOperation(String str) {
        if (str.length() != 1) {
            return false;
        }

        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private static String integerToRomanNumber(int input) throws Exception {
        if (input < 1 || input > 3999) {
            throw new Exception("Invalid Roman Number Value");
        }

        StringBuilder s = new StringBuilder();
        while (input >= 1000) {
            s.append("M");
            input -= 1000;        }
        while (input >= 900) {
            s.append("CM");
            input -= 900;
        }
        while (input >= 500) {
            s.append("D");
            input -= 500;
        }
        while (input >= 400) {
            s.append("CD");
            input -= 400;
        }
        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }

        return s.toString();
    }
}
