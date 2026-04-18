package com.moosa.interviewlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moosa.interviewlog.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByUserId(Long userId);
}