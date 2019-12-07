package com.infoshareacademy.domain.parser;

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
            return  "\u001b[37;1m" + name + "\u001b[0m\n"+ "Dokładna lokalizacja: " + subname ;
        } else {
            return "\u001b[37;1m" + name + "\u001b[0m";
        }
    }
}
