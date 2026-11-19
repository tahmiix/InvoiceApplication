package com.codewiththamsanqa.invoicegenerator.dto;

import jakarta.persistence.Column;

public record CompanyRequest(
         String name,
         String email,
         String phone,
         String address,
         String vatNumber
) {
}
