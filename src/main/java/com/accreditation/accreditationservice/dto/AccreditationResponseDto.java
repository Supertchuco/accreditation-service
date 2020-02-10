package com.accreditation.accreditationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class AccreditationResponseDto implements Serializable {

    private boolean success;

    private boolean accredited;
}
