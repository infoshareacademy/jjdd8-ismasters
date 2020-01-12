package com.isa.Parser.DomainClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {

    @JsonProperty("fileName")
    private String fileName;

    public Attachment(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
