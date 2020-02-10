package com.accreditation.accreditationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccreditationDto implements Serializable {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("payload")
    private PayloadDto payloadDto;

}
