package com.example.demo.infrastructure.registration;

import com.example.demo.domain.registration.Registration;
import com.example.demo.domain.registration.RegistrationReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationReaderImpl implements RegistrationReader {
    private final RegistrationRepository registrationRepository;

    @Override
    public Page<Registration> getHistoryByCategoryAndDtlCategoryAndKwd(String category, String dtlCategory, String kwd, PageRequest pageRequest) {
        if(category.equals("All")) {
            category = "%";
        }
        if(dtlCategory.equals("All")) {
            dtlCategory = "%";
        }
        if(StringUtils.isEmpty(kwd)) {
            kwd = "%";
        } else {
            kwd = "%" + kwd + "%";
        }
        return registrationRepository.findHistory(category, dtlCategory, kwd, pageRequest);
    }

    @Override
    public List<Registration> getExcelDataByCategoryAndDtlCategoryAndKwd(String category, String dtlCategory, String kwd) {
        if(category.equals("All")) {
            category = "%";
        }
        if(dtlCategory.equals("All")) {
            dtlCategory = "%";
        }
        if(StringUtils.isEmpty(kwd)) {
            kwd = "%";
        } else {
            kwd = "%" + kwd + "%";
        }
        return registrationRepository.findExcelData(category, dtlCategory, kwd);
    }

    @Override
    public Registration getRegistration(Long registrationId) {
        return registrationRepository.findById(registrationId).orElseThrow(EntityNotFoundException::new);
    }
}
