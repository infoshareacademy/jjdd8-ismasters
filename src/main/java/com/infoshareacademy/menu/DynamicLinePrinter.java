package com.infoshareacademy.menu;

public class DynamicLinePrinter {

//    public static final String RED = "\u001b[31m";
//    public static final String GREEN = "\u001b[32m";
//    public static final String YELLOW = "\u001b[33m";
//    public static final String PURPLE = "\u001b[35m";
//    public static final String CYAN = "\u001b[36m";
//    public static final String WHITE = "\u001b[37m";
//    public static final String DEFAULT = "\u001b[0m";

    static String printDynamic(String input) {

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

    static String printDynamicYellow(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[33m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    static String printDynamicCyan(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[36m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    static String printDynamicPurple(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[35m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    static String printDynamicRed(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[31m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1 - 10; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }
}