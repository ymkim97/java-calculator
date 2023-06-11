package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.ExceptionConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;

public class InputValidator {

    public void checkCommandInput(String input) {
        if (!isInteger(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);
        }

        if (!isInBoundary(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);
        }
    }

    private boolean isInteger(String input) {
        return input.matches("^[-]?\\d*$");
    }

    private boolean isInBoundary(String input) {
        int command = Integer.parseInt(input);
        return (command >= 1 && command <= 3);
    }

    public boolean isOperator(String token) {
        return token.matches("^[\\+\\-\\*\\/]$");
    }

    public void checkCalculateHistoryLength(LinkedHashMap<Integer, String> calculateHistory) {
        if (calculateHistory.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);
        }
    }

    public void checkEquationInput(String equation) {
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(equation.split(" ")));

        if (equation.length() == 0) {
            throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }

        if (!isInteger(tokens.get(0))) {
            throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }

        int digit = 0;
        int operation = 0;

        for (String eachToken: tokens) {
            if (isInteger(eachToken)) {
                digit += 1;
            } else if (isOperator(eachToken)) {
                operation += 1;
            } else {
                throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
            }
        }

        if (digit - operation > 1 || operation >= digit || digit + operation == 1) {
            throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }
}
