package com.example.demo.interfaces.registration;

import com.example.demo.domain.registration.RegistrationService;
import com.example.demo.global.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.example.demo.global.util.Constants.API_PREFIX;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(API_PREFIX + "/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final RegistrationDtoMapper registrationDtoMapper;

    @GetMapping("/test")
    public CommonResponse test() {
        String response = "console output success!";
        return CommonResponse.success(response);
    }

    @PostMapping("/new")
    public CommonResponse saveRegistration(@Valid RegistrationDto.SaveRegistrationRequest request) {
        var registrationCommand = registrationDtoMapper.of(request);
        var registration = registrationService.saveRegistration(registrationCommand);
        return CommonResponse.success("OK");
    }

    @GetMapping("/history")
    public CommonResponse retrieveRegistration(@Valid RegistrationDto.GetHistoryRequest request) {
        var registration = registrationService.retrieveRegistration(request);
        var response = registrationDtoMapper.of(registration);
        return CommonResponse.success(response);
    }

    @GetMapping("/excelData")
    public CommonResponse retrieveExcelData(@Valid RegistrationDto.GetHistoryRequest request) {
        var registration = registrationService.retrieveExcelData(request);
        var response = registrationDtoMapper.of(registration);
        return CommonResponse.success(response);
    }

    @PostMapping("/{registrationId}")
    public CommonResponse updateRegistration(@PathVariable("registrationId") Long registrationId,
                                             @Valid RegistrationDto.SaveRegistrationRequest request) {
        var registrationCommand = registrationDtoMapper.of(request);
        registrationService.updateRegistration(registrationCommand, registrationId);
        return CommonResponse.success("OK");
    }

    @DeleteMapping("/{registrationId}")
    public CommonResponse deleteRegistration(@PathVariable("registrationId") Long registrationId) {
        registrationService.deleteRegistration(registrationId);
        return CommonResponse.success("OK");
    }

    @PostMapping("/vote/{registrationId}")
    public CommonResponse vote(@PathVariable("registrationId") Long registrationId) {
        registrationService.vote(registrationId);
        return CommonResponse.success("OK");
    }
}
