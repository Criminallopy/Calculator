package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberProcessor {

    public static Map<String, Integer> romanToInt = new HashMap<>();

    RomanNumberProcessor() {
        initRomanToIntMap();
    }

    public int romanNumberToInteger(String roman) throws Exception {
        try {
            return romanToInt.get(roman);
        } catch (Exception exception) {
            throw new Exception("Операнд не является римским числом");
        }
    }

    public String integerToRomanNumber(int input) throws Exception {
        if (input < 1 || input > 3999) {
            throw new Exception("В римской системе нет чисел вне диапазона [1; 3999]");
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

    private void initRomanToIntMap() {
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
}
