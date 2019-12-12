package com.infoshareacademy.menu;

public class EmptyLineWithPipesPrinter {
    public String printEmptyLineWithPipe() {
        String returnString = "│";
        for (int i = 1; i < MenuBuilder.length - 1; i++) {
            returnString += " ";
        }
        returnString += "│\n";
        return returnString;
    }
}
