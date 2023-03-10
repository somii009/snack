package com.example.demo.domain.registration;

import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.ERROR)

public interface RegistrationInfoMapper {

    @Mappings({
            @Mapping(source = "registration.id", target = "boardNo"),
            @Mapping(expression = "java(registration.getUpdatedDate())", target = "regDt")})
    RegistrationInfo.Result of(Registration registration);

//    @Mappings({
//            @Mapping(expression = "java(registrationPage.getPageable().getPageNumber())", target = "currentPage"),
//            @Mapping(expression = "java(registrationPage.getPageable().getPageSize())", target = "pageUnit"),
//            @Mapping(expression = "java(registrationPage.getTotalPages())", target = "totalSize")})
//    RegistrationInfo.PagingInfo of(Page registrationPage);
}
