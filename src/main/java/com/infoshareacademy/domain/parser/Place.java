package com.infoshareacademy.domain.parser;

import com.infoshareacademy.menu.styleSettings.ColorHandler;

public class Place {
    private int id;
    private String subname;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubname() {
        if (this.subname != null){
            return this.subname;
        }
        else {
            return this.subname ="Brak";
        }

    }

    public void setSubname(String subname) {
        this.subname = subname;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {


        if (subname != null) {
            return  ColorHandler.white + name + ColorHandler.reset  + "\n" + " Dokładna lokalizacja: " + subname ;
        } else {
            return ColorHandler.white + name + ColorHandler.reset;
        }
    }
}
