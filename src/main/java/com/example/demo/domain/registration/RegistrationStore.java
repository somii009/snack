package com.example.demo.domain.registration;

public interface RegistrationStore {
    Registration store(Registration registration);
    void deleteRegistration(Registration registration);
}
