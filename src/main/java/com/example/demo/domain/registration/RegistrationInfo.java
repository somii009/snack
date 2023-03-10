package com.example.demo.domain.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public class RegistrationInfo {

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Main {
        private final List<Result> resultList;
        private final PagingInfo pagingInfo;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class ExcelData {
        private final List<Result> resultList;
    }

    @Getter
    @Builder
    @ToString
    public static class Result {
        private final int boardNo;
        private final String category;
        private final String dtlCategory;
        private final String name;
        private final String regId;
        private final int vote;
        private final String conts;
        private final String regDt;

    }

    @Getter
    @Builder
    @ToString
    public static class PagingInfo {
        private final int currentPage;
        private final int pageUnit;
        private final long totalSize;
    }

}
