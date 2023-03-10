package com.example.demo.domain.registration;

import com.example.demo.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "registration")
public class Registration extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String dtlCategory;
    private String regId;
    private String name;
    private String conts;
    private int vote;

    public String getUpdatedDate() {
        return this.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Builder
    public Registration(String category, String dtlCategory, String regId, String name, String conts) {
        this.category = category;
        this.dtlCategory = dtlCategory;
        this.regId = regId;
        this.name = name;
        this.conts = conts;
        this.vote = 0;
    }

    public void update(RegistrationCommand.RegisterRequest request) {
        this.category = request.getCategory();
        this.dtlCategory = request.getDtlCategory();
        this.regId = request.getRegId();
        this.name = request.getName();
        this.conts = request.getConts();
    }

    public void vote() {
        this.vote += 1;
    }

}
