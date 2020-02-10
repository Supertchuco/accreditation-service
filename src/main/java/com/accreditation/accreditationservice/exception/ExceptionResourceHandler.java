package com.accreditation.accreditationservice.exception;

import com.accreditation.accreditationservice.dto.AccreditationResponseDto;
import com.accreditation.accreditationservice.enumerator.AccreditationResponseMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class ExceptionResourceHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(final Exception exception, final WebRequest request) {
        log.error("Unexpected error", exception);
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), AccreditationResponseMessages.UNEXPECTED_ERROR.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccreditationUserProcessException.class)
    public final ResponseEntity<AccreditationResponseDto> handleAccreditationUserProcessException(final WebRequest request) {
        return new ResponseEntity<>(new AccreditationResponseDto(false, false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccreditationFailedException.class)
    public final ResponseEntity<AccreditationResponseDto> handleAccreditationFailedException(final WebRequest request) {
        return new ResponseEntity<>(new AccreditationResponseDto(true, false), HttpStatus.OK);
    }

}
