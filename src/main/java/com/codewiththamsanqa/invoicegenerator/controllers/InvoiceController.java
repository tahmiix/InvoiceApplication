package com.codewiththamsanqa.invoicegenerator.controllers;

import com.codewiththamsanqa.invoicegenerator.dto.InvoiceRequest;
import com.codewiththamsanqa.invoicegenerator.dto.InvoiceResponse;
import com.codewiththamsanqa.invoicegenerator.entity.Invoice;
import com.codewiththamsanqa.invoicegenerator.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;


    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request){
        InvoiceResponse response = invoiceService.createInvoice(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
