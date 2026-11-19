package com.codewiththamsanqa.invoicegenerator.dto;

import com.codewiththamsanqa.invoicegenerator.entity.Company;

public record CompanyResponse(
        String name,
        String email,
        String phone,
        String address,
        String vatNumber
) {

    public static  CompanyResponse fromEntity(Company company){
        return new CompanyResponse(
                company.getName(),
                company.getEmail(),
                company.getPhone(),
                company.getAddress(),
                company.getVatNumber()
        );
    }
}
