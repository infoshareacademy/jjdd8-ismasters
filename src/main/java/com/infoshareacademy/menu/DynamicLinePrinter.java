package com.infoshareacademy.menu;

class DynamicLinePrinter {

    static final int WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE = 2;
    static final int WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD = 1;

    private static String printDynamicBottomPart(String input, StringBuilder stringBuilder) {

        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        whiteSpaceAppendForEvenInputStringWidth(input, stringBuilder);
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    private static void whiteSpaceAppendForEvenInputStringWidth(String input, StringBuilder stringBuilder) {
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
    }

    static String printDynamicMenuRows(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        return printDynamicBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsYellow(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.YELLOW);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return printDynamicBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsCyan(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.CYAN);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return printDynamicBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsPurple(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.PURPLE);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return printDynamicBottomPart(input, stringBuilder);
    }

    static String printDynamicMenuRowsRed(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.LENGTH - input.length()) / WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE - WIDTH_CALCULATIONS_AUXILIARY_VARAIABLE_FOR_ODD; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(MenuBuilder.RED);
        stringBuilder.append(input);
        stringBuilder.append(MenuBuilder.DEFAULT);
        return printDynamicBottomPart(input, stringBuilder);
    }
}