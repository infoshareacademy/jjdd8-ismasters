package com.infoshareacademy.menu;

public class EmptyLineWithPipesPrinter {
    public String printingEmptyLineWithPipe() {
        String returnString = "│";
        for (int i = 1; i < MenuBuilder.LENGTH - 1; i++) {
            returnString += " ";
        }
        returnString += "│\n";
        return returnString;
    }
}
