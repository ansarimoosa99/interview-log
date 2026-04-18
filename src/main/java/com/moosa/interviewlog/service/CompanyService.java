package com.moosa.interviewlog.service;


import org.springframework.stereotype.Service;
import com.moosa.interviewlog.entity.Company;
import com.moosa.interviewlog.entity.User;
import com.moosa.interviewlog.repository.CompanyRepository;
import com.moosa.interviewlog.repository.UserRepository;
import com.moosa.interviewlog.security.SecurityUtil;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;


    public CompanyService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public List<Company> getAllCompanies() {
        String email = SecurityUtil.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        return companyRepository.findByUserId(user.getId());
    }

    public Company createCompany(Company company) {
        String email = SecurityUtil.getCurrentUserEmail();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        company.setUser(user);
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