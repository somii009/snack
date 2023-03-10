package com.example.demo.domain.registration;

import com.example.demo.interfaces.registration.RegistrationDto;
import org.springframework.data.domain.Page;

public interface RegistrationService {
    Registration saveRegistration(RegistrationCommand.RegisterRequest request);
    RegistrationInfo.Main retrieveRegistration(RegistrationDto.GetHistoryRequest request);
    RegistrationInfo.ExcelData retrieveExcelData(RegistrationDto.GetHistoryRequest request);
    void updateRegistration(RegistrationCommand.RegisterRequest request, Long registrationId);
    void deleteRegistration(Long registrationId);
    void vote(Long registrationId);
}
