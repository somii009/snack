package com.example.demo.infrastructure.registration;

import com.example.demo.domain.registration.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query(nativeQuery = true, value = "SELECT * " +
    "FROM registration " +
    "WHERE CATEGORY LIKE :category AND DTL_CATEGORY LIKE :dtlCategory AND NAME LIKE :kwd")
    Page<Registration> findHistory(@Param("category") String category,
                                   @Param("dtlCategory") String dtlCategory,
                                   @Param("kwd") String kwd,
                                   PageRequest pageRequest);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM registration " +
            "WHERE CATEGORY LIKE :category AND DTL_CATEGORY LIKE :dtlCategory AND NAME LIKE :kwd")
    List<Registration> findExcelData(String category, String dtlCategory, String kwd);

    Optional<Registration> findById(Long registrationId);

}
