package com.example.demo.domain.registration;

import com.example.demo.interfaces.registration.RegistrationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationStore registrationStore;
    private final RegistrationReader registrationReader;
    private final RegistrationInfoMapper registrationInfoMapper;

    @Override
    @Transactional
    public Registration saveRegistration(RegistrationCommand.RegisterRequest request) {
        var registration = registrationStore.store(request.toEntity());
        return registration;
    }

    @Override
    @Transactional
    public RegistrationInfo.Main retrieveRegistration(RegistrationDto.GetHistoryRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getCurrentPage()-1, request.getPageUnit(), Sort.by(Sort.Direction.DESC, "UPDATED_AT"));
        Page<Registration> registration = registrationReader.getHistoryByCategoryAndDtlCategoryAndKwd(request.getCategory(), request.getDtlCategory(), request.getKwd(), pageRequest);
        var resultList = registration.getContent().stream()
                .map(reg -> {
                    return registrationInfoMapper.of(reg);
                })
                .collect(Collectors.toList());
        var pagingInfo = RegistrationInfo.PagingInfo.builder()
                .currentPage(registration.getPageable().getPageNumber() + 1)
                .pageUnit(registration.getPageable().getPageSize())
                .totalSize(registration.getTotalElements())
                .build();

        return new RegistrationInfo.Main(resultList, pagingInfo);
    }

    @Override
    @Transactional
    public RegistrationInfo.ExcelData retrieveExcelData(RegistrationDto.GetHistoryRequest request) {
        List<Registration> registration = registrationReader.getExcelDataByCategoryAndDtlCategoryAndKwd(request.getCategory(), request.getDtlCategory(), request.getKwd());
        var resultList = registration.stream()
                .map(reg -> {
                    return registrationInfoMapper.of(reg);
                })
                .collect(Collectors.toList());
        return new RegistrationInfo.ExcelData(resultList);
    }

    @Override
    @Transactional
    public void updateRegistration(RegistrationCommand.RegisterRequest request, Long registrationId) {
        var registration = registrationReader.getRegistration(registrationId);
        registration.update(request);
    }

    @Override
    @Transactional
    public void deleteRegistration(Long registrationId) {
        var registration = registrationReader.getRegistration(registrationId);
        registrationStore.deleteRegistration(registration);
    }

    @Override
    @Transactional
    public void vote(Long registrationId) {
        var registration = registrationReader.getRegistration(registrationId);
        registration.vote();
    }
}
