package com.codewiththamsanqa.invoicegenerator.dto;

import com.codewiththamsanqa.invoicegenerator.entity.Company;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceRequest(
      Company company,
      @NotNull  String description,
      @NotNull  BigDecimal amount,
      @NotNull LocalDate dueDate


) {
}
