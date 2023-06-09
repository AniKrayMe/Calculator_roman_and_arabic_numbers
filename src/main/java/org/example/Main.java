package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        calc("VII+X+X");

    }

    public static void calc(String exp) throws Exception {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};  //Этот масив я создал для строки номер 26, нужен для split
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            throw new Exception("Некорректное выражение");
        }

        String[] data = exp.split(regexActions[actionIndex]);
        if (converter.isRoman(data[0]) == converter.isRoman(data[1]) && data.length == 2) {
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);


                if (a > 10 || b > 10) {
                    throw new Exception("только числа от 1 до 10-и");
                }
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
                if (a > 10 || b > 10) {
                    throw new Exception("только числа от 1 до 10-и");
                }
            }
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            if (isRoman) {
                System.out.println(converter.intToRoman(result));
            } else {
                System.out.println(result);
            }
        } else {
            throw new Exception("incorrect input");
        }

    }

}



