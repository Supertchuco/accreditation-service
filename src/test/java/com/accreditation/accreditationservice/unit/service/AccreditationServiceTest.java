package com.accreditation.accreditationservice.unit.service;

import com.accreditation.accreditationservice.dto.AccreditationDto;
import com.accreditation.accreditationservice.exception.AccreditationFailedException;
import com.accreditation.accreditationservice.service.AccreditationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
public class AccreditationServiceTest {

    @InjectMocks
    private AccreditationService accreditationService;

    private Object[] inputArray;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAccreditObjectInputWithSuccess() {
        inputArray = new Object[]{buildAccreditationDto(), 4};
        ReflectionTestUtils.invokeMethod(accreditationService, "verifyAccreditation", inputArray);
    }

    @Test(expected = AccreditationFailedException.class)
    public void shouldThrowAccreditationFailedExceptionWhenNotAccreditObjectInput() {
        inputArray = new Object[]{buildAccreditationDto(), 9};
        ReflectionTestUtils.invokeMethod(accreditationService, "verifyAccreditation", inputArray);
    }

    private AccreditationDto buildAccreditationDto() {
        return new AccreditationDto();
    }
}
