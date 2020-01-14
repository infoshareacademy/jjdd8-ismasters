package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttachmentApi {

    @JsonProperty("fileName")
    private String fileName;

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
