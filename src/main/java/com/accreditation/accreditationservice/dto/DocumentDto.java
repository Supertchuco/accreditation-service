package com.accreditation.accreditationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DocumentDto implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("content")
    private String content;

}
