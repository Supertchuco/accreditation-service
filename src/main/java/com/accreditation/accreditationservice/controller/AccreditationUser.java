package com.accreditation.accreditationservice.controller;

import com.accreditation.accreditationservice.dto.AccreditationDto;
import com.accreditation.accreditationservice.dto.AccreditationResponseDto;
import com.accreditation.accreditationservice.service.AccreditationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Accreditation for a user controller")
@Slf4j
@Controller
public class AccreditationUser {

    @Autowired
    private AccreditationService accreditationService;

    @PostMapping(value = "/accreditation")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Accreditation for a user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = AccreditationResponseDto.class),
            @ApiResponse(code = 400, message = "Bad Request", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server ErrorMessage", response = String.class)
    })

    public AccreditationResponseDto accreditationUser(@Valid @RequestBody AccreditationDto accreditationDto) {
        return accreditationService.verifyAccreditationUserProcess(accreditationDto);
    }

}
