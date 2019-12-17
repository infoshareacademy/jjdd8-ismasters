package com.infoshareacademy.menu;

class DynamicLinePrinter {

    final static int widthCalculationsAuxiliaryVaraiable = 2;
    final static int widthCalculationsAuxiliaryVaraiableForOdd = 1;

    private static String dynamicPrintingBottomPart(String input, StringBuilder stringBuilder) {

        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        whiteSpaceAppendingForEvenInputStringWidth(input, stringBuilder);
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    private static void whiteSpaceAppendingForEvenInputStringWidth(String input, StringBuilder stringBuilder) {
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
    }

    static String printingDynamicMenuRows(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        return dynamicPrintingBottomPart(input, stringBuilder);
    }

    static String printingDynamicMenuRowsYellow(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.YELLOW);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintingBottomPart(input, stringBuilder);
    }

    static String printingDynamicMenuRowsCyan(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.CYAN);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintingBottomPart(input, stringBuilder);
    }

    static String printingDynamicMenuRowsPurple(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.PURPLE);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintingBottomPart(input, stringBuilder);
    }

    static String printingDynamicMenuRowsRed(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / widthCalculationsAuxiliaryVaraiable - widthCalculationsAuxiliaryVaraiableForOdd; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.RED);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return dynamicPrintingBottomPart(input, stringBuilder);
    }
}