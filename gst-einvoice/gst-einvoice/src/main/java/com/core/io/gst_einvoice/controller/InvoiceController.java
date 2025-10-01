package com.core.io.gst_einvoice.controller;

import com.core.io.gst_einvoice.dto.request.InvoiceRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.core.io.gst_einvoice.service.*;

/**
 * REST controller for creating and posting e-invoices to GSTZen.
 */
@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceServiceImp invoiceService;
    @PostMapping("/generate-and-post")
    public ResponseEntity<InvoiceRequestDTO> generateAndPost(
            @RequestBody InvoiceRequestDTO invoiceRequest) {

        InvoiceRequestDTO fullInvoice = invoiceService.generateAndPostInvoice(invoiceRequest);
        return ResponseEntity.ok(fullInvoice);
    }
}
