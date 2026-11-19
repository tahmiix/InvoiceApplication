package com.codewiththamsanqa.invoicegenerator.repository;

import com.codewiththamsanqa.invoicegenerator.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
