package com.accreditation.accreditationservice.service;

import com.accreditation.accreditationservice.dto.AccreditationDto;
import com.accreditation.accreditationservice.dto.AccreditationResponseDto;
import com.accreditation.accreditationservice.exception.AccreditationFailedException;
import com.accreditation.accreditationservice.exception.AccreditationUserProcessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class AccreditationService {

    private void verifyAccreditation(final AccreditationDto accreditation, final int randomNumber) {
        log.info("Verify object accreditation for accreditation user id: {}", accreditation.getUserId());
        /* As said in test description, I don't need to implement this logic to verify accreditation, just I need to simulate this behavior */
        if (randomNumber % 2 != 0) {
            log.info("Object input was not accredited");
            throw new AccreditationFailedException();
        }
    }

    public AccreditationResponseDto verifyAccreditationUserProcess(final AccreditationDto accreditation) {
        log.info("Verify accreditation user process");
        try {
            verifyAccreditation(accreditation, ThreadLocalRandom.current().nextInt(1, 11));
            return new AccreditationResponseDto(true, true);
        } catch (AccreditationFailedException accreditationFailedException) {
            throw accreditationFailedException;
        } catch (Exception exception) {
            log.error("Error in verify accreditation user process", exception);
            throw new AccreditationUserProcessException();
        }
    }

}
