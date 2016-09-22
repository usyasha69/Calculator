package com.example.pk.calculator;


import java.util.ArrayList;

public class Calculator {

    /**
     * This method calculate expression in edit text view and return result.
     *
     * @param expression - String expression
     * @return - result of expression
     */
    public static String calculateExpression(String expression) {
        if (expression.equals("")) {
            return "";
        }

        String[] numbers = expression.split("\\+|/|\\*|-");

        //list with numbers
        ArrayList<Double> numbersToDouble = new ArrayList<>();

        //filling list with numbers
        for (String number : numbers) {
            numbersToDouble.add(Double.parseDouble(number));
        }

        //list with operators
        ArrayList<Character> operators = new ArrayList<>();

        //filing list with operators
        char[] expressionToCharArray = expression.toCharArray();

        for (char c : expressionToCharArray) {
            if (c == '*' || c == '-' || c == '+' || c == '/') {
                operators.add(c);
            }
        }

        //operator counters
        int multiplyCount = 0;
        int divideCount = 0;
        int plusCount = 0;
        int minusCount = 0;

        //multiply operation
        while (numbersToDouble.size() != 1) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '*') {
                    multiplyCount++;
                    double temp = numbersToDouble.get(i) * numbersToDouble.get(i + 1);

                    numbersToDouble.remove(i);
                    numbersToDouble.remove(i);

                    numbersToDouble.add(i, temp);

                    operators.remove(i);
                }
            }

            if (multiplyCount == 0) {
                break;
            } else {
                multiplyCount = 0;
            }
        }


        //divide operation
        while (numbersToDouble.size() != 1) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '/') {
                    divideCount++;
                    double temp = numbersToDouble.get(i) / numbersToDouble.get(i + 1);

                    numbersToDouble.remove(i);
                    numbersToDouble.remove(i);

                    numbersToDouble.add(i, temp);

                    operators.remove(i);
                }
            }

            if (divideCount == 0) {
                break;
            } else {
                divideCount = 0;
            }
        }

        //minus operation
        while (numbersToDouble.size() != 1) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '-') {
                    minusCount++;
                    double temp = numbersToDouble.get(i) - numbersToDouble.get(i + 1);

                    numbersToDouble.remove(i);
                    numbersToDouble.remove(i);

                    numbersToDouble.add(i, temp);

                    operators.remove(i);
                }
            }

            if (minusCount == 0) {
                break;
            } else {
                minusCount = 0;
            }
        }

        //plus operation
        while (numbersToDouble.size() != 1) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == '+') {
                    plusCount++;
                    double temp = numbersToDouble.get(i) + numbersToDouble.get(i + 1);

                    numbersToDouble.remove(i);
                    numbersToDouble.remove(i);

                    numbersToDouble.add(i, temp);

                    operators.remove(i);
                }
            }

            if (plusCount == 0) {
                break;
            } else {
                plusCount = 0;
            }
        }

        return String.valueOf(numbersToDouble.get(0));
    }
}
