package com.example.demo.infrastructure.registration;

import com.example.demo.domain.registration.Registration;
import com.example.demo.domain.registration.RegistrationStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationStoreImpl implements RegistrationStore {
    private final RegistrationRepository registrationRepository;

    @Override
    public Registration store(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Registration registration) {
        registrationRepository.delete(registration);
    }
}
