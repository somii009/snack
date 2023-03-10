package com.example.demo.interfaces.registration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class RegistrationDto {
    @Getter
    @Setter
    @ToString
    public static class SaveRegistrationRequest {
        private String flg;
        private String boardNo;
        private String category;
        private String dtlCategory;
        private String name;
        private String regId;
        private String conts;
    }

    @Getter
    @Setter
    @ToString
    public static class GetHistoryRequest {
        private String category;
        private String dtlCategory;
        private String kwd;
        private int currentPage;
        private int pageUnit;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveResponse {
        private List<Result> resultList;
        private PagingInfo pagingInfo;
    }

    @Getter
    @Setter
    @ToString
    public static class RetrieveExcelData {
        private List<Result> resultList;
    }

    @Getter
    @Setter
    @ToString
    public static class Result {
        private int boardNo;
        private String category;
        private String dtlCategory;
        private String name;
        private String regId;
        private int vote;
        private String conts;
        private String regDt;
    }

    @Getter
    @Setter
    @ToString
    public static class PagingInfo {
        private int currentPage;
        private int pageUnit;
        private long totalSize;
    }
}
