package com.accreditation.accreditationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class PayloadDto implements Serializable {

    @JsonProperty("accreditation_type")
    private String accreditationType;

    @JsonProperty("documents")
    private List<DocumentDto> documentDtos;

}
