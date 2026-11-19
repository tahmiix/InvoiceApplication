package com.codewiththamsanqa.invoicegenerator.services;

import com.codewiththamsanqa.invoicegenerator.dto.CompanyRequest;
import com.codewiththamsanqa.invoicegenerator.dto.CompanyResponse;
import com.codewiththamsanqa.invoicegenerator.entity.Company;
import com.codewiththamsanqa.invoicegenerator.repository.CompanyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    final CompanyRepository companyRepository;


    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    public CompanyResponse createCompany(CompanyRequest request){
       Company company = new Company();

       company.setName(request.name());
       company.setAddress(request.address());
       company.setEmail(request.email());
       company.setPhone(request.phone());
       company.setVatNumber(request.vatNumber());

       Company savedCompany = companyRepository.save(company);

       return CompanyResponse.fromEntity(savedCompany);


    }
}
