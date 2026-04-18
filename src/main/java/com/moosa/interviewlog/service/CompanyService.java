package com.moosa.interviewlog.service;


import org.springframework.stereotype.Service;
import com.moosa.interviewlog.entity.Company;
import com.moosa.interviewlog.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        Company existing = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existing.setName(updatedCompany.getName());
        existing.setRole(updatedCompany.getRole());
        existing.setStatus(updatedCompany.getStatus());
        existing.setNotes(updatedCompany.getNotes());

        return companyRepository.save(existing);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}