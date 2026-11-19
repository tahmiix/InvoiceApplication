package com.codewiththamsanqa.invoicegenerator.dto;

import com.codewiththamsanqa.invoicegenerator.entity.Company;
import com.codewiththamsanqa.invoicegenerator.entity.Invoice;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceResponse(
        Long invoiceNumber,
        Company company,
        String description,
        BigDecimal amount,
        BigDecimal vat,
        LocalDate issueDate,
        LocalDate dueDate) {

    public static InvoiceResponse fromEnitity(Invoice invoice){
        return new InvoiceResponse(
                invoice.getInvoiceNumber(),
                invoice.getCompany(),
                invoice.getDescription(),
                invoice.getAmount(),
                invoice.getVat(),
                invoice.getIssueDate(),
                invoice.getDueDate()
        );
    }
}
