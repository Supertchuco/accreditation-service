package com.accreditation.accreditationservice.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccreditationResponseMessages {

    UNEXPECTED_ERROR("Unexpected error happened");

    private String message;

}
