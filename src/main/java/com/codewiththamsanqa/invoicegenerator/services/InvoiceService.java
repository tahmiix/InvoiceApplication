package com.codewiththamsanqa.invoicegenerator.services;

import com.codewiththamsanqa.invoicegenerator.dto.InvoiceRequest;
import com.codewiththamsanqa.invoicegenerator.dto.InvoiceResponse;
import com.codewiththamsanqa.invoicegenerator.entity.Company;
import com.codewiththamsanqa.invoicegenerator.entity.Invoice;
import com.codewiththamsanqa.invoicegenerator.entity.InvoiceStatus;
import com.codewiththamsanqa.invoicegenerator.exceptions.ResponseException;
import com.codewiththamsanqa.invoicegenerator.repository.CompanyRepository;
import com.codewiththamsanqa.invoicegenerator.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class InvoiceService {

    final InvoiceRepository invoiceRepository;
    final CompanyRepository companyRespository;

    public InvoiceService(InvoiceRepository invoiceRepository, CompanyRepository companyRespository, CompanyRepository companyRespository1){
        this.invoiceRepository = invoiceRepository;
        this.companyRespository = companyRespository;

    }


    public InvoiceResponse createInvoice(InvoiceRequest request){
      Company company = companyRespository.findById(request.company().getId())
              .orElseThrow(() -> new ResponseException("Notfound"));

        Invoice invoice = new Invoice();

        BigDecimal vat = request.amount().multiply(new BigDecimal("0.14"));

        invoice.setInvoiceNumber(System.currentTimeMillis());
        invoice.setCompany(company);
        invoice.setAmount(request.amount());
        invoice.setDueDate(request.dueDate());
        invoice.setStatus(InvoiceStatus.SENT);
        invoice.setVat(vat);

        Invoice savedInvoice = invoiceRepository.save(invoice);

        return InvoiceResponse.fromEnitity(savedInvoice);

    }
}
