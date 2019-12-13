package com.infoshareacademy.menu;

public class DynamicLinePrinter {

    private static String dynamicPrintBottomPart(String input, StringBuilder stringBuilder) {

        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        if (input.length() % 2 != 0) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("│\n");
        return stringBuilder.toString();
    }

    static String printDynamic(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(input);
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicYellow(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[33m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicCyan(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[36m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicPurple(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[35m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        return dynamicPrintBottomPart(input, stringBuilder);
    }

    static String printDynamicRed(String input) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("│");
        for (int i = 0; i < (MenuBuilder.length - input.length()) / 2 - 1; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("\u001b[31m");
        stringBuilder.append(input);
        stringBuilder.append("\u001b[0m");
        return dynamicPrintBottomPart(input, stringBuilder);
    }
}