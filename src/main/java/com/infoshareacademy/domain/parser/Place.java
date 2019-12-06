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
        return  name + '\n'+
                "Dokładna lokalizacja " + subname ;
    }
}
