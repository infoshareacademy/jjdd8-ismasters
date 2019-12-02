package com.infoshareacademy.Parser;

public class Place {
   private String ID;
   private  String subname;
   private String name;

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getSubname() {
        return subname;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
