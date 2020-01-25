package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AttachmentApi {

    @JsonProperty("fileName")
    @JsonIgnore
    private String fileName;

    @JsonIgnore
    public String getFileName() {
        return fileName;
    }

    @JsonIgnore
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
