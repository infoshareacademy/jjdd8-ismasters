package com.infoshareacademy.menu;

public class DynamicLinePrinter {

    final static int widthCalculationsAuxiliaryVaraiable = 2;
    final static int widthCalculationsAuxiliaryVaraiableForOdd = 1;

    private static String dynamicPrintBottomPart(String input, StringBuilder stringBuilder) {

        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        checkingIfOddInput(input, stringBuilder);
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    private static void checkingIfOddInput(String input, StringBuilder stringBuilder) {
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
    }

    static String printDynamicMenuRows(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsYellow(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.YELLOW);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsCyan(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.CYAN);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsPurple(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.PURPLE);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsRed(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.RED);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintBottomPart(input, stringBuilder);
    }
}