package com.infoshareacademy.menu;

public class DynamicLinePrinter {

    static String printDynamicMenu(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }
}
