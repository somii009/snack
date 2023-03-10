package com.example.demo.interfaces.registration;

import com.example.demo.domain.registration.RegistrationCommand;
import com.example.demo.domain.registration.RegistrationInfo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RegistrationDtoMapper {
    // Register
    RegistrationCommand.RegisterRequest of(RegistrationDto.SaveRegistrationRequest request);

    // Retrieve
    RegistrationDto.RetrieveResponse of(RegistrationInfo.Main registrationInfo);
    RegistrationDto.Result of(RegistrationInfo.Result resultList);
    RegistrationDto.RetrieveExcelData of(RegistrationInfo.ExcelData resultList);
}