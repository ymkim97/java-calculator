package com.devcourse.java.calculator.constant;

import java.util.InputMismatchException;

public enum Menu {
    START_CALCULATOR_NO(0),
    SELECTED_PRINT_HISTORY(1),
    SELECTED_CALCULATE(2),
    SELECTED_EXIT(3);

    private final int commandNum;

    Menu (int commandNum) {
        this.commandNum = commandNum;
    }

    public static Menu getCommandMenu(String commandNum) {
        switch (commandNum) {
            case "1":
                return SELECTED_PRINT_HISTORY;
            case "2":
                return SELECTED_CALCULATE;
            case "3":
                return SELECTED_EXIT;
            default:
                throw new InputMismatchException(ExceptionMessageConstant.COMMAND_INPUT_EXCEPTION);
        }
    }

}
