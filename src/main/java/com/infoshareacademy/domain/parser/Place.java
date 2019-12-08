package com.infoshareacademy.domain.parser;

import com.infoshareacademy.menu.additionStyleClasses.ColorHandler;

public class Place {
    private int id;
    private String subname;
    private String name;

    @Override
    public String toString() {


        if (subname != null) {
            return  ColorHandler.WHITE + name + ColorHandler.DEFAULT + "\n" + "Dokładna lokalizacja: " + subname ;
        } else {
            return ColorHandler.WHITE + name + ColorHandler.DEFAULT;
        }
    }
}
