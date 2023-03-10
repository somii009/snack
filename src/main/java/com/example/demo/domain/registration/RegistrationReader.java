package com.example.demo.domain.registration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RegistrationReader {
    Page<Registration> getHistoryByCategoryAndDtlCategoryAndKwd(String category, String dtlCategory, String kwd, PageRequest pageRequest);
    List<Registration> getExcelDataByCategoryAndDtlCategoryAndKwd(String category, String dtlCategory, String kwd);
    Registration getRegistration(Long registrationId);
}
