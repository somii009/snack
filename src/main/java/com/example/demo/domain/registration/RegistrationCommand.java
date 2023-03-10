package com.example.demo.domain.registration;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class RegistrationCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterRequest {
        private final String category;
        private final String dtlCategory;
        private final String regId;
        private final String name;
        private final String conts;

        public Registration toEntity() {
            return Registration.builder()
                    .category(category)
                    .dtlCategory(dtlCategory)
                    .regId(regId)
                    .name(name)
                    .conts(conts)
                    .build();
        }
    }
}
