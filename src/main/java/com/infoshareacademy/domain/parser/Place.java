package com.infoshareacademy.domain.parser;

import com.infoshareacademy.menu.MenuBuilder;

public class Place {
    private int id;
    private String subname;
    private String name;


    public Place() {
    }

    public Place(int id, String subname, String name) {
        this.id = id;
        this.subname = subname;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubname() {
        return subname;
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
            return MenuBuilder.CYAN + name + MenuBuilder.DEFAULT + "\n" + "Dokładna lokalizacja: " + subname ;
        } else {
            return MenuBuilder.CYAN + name + MenuBuilder.DEFAULT;
        }
    }
}
