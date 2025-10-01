package com.core.io.gsteinvoice.controller;

import com.core.io.gsteinvoice.dto.request.InvoiceRequestDTO;
import com.core.io.gsteinvoice.dto.response.InvoiceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.core.io.gsteinvoice.service.*;


@RestController
@RequestMapping("/api/einvoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceServiceImp invoiceService;
    @PostMapping("/generate")
    public ResponseEntity<InvoiceResponseDTO> generateAndPost(@RequestBody InvoiceRequestDTO request) {
        InvoiceResponseDTO response = invoiceService.generateAndPostInvoice(request);
        return ResponseEntity.ok(response);
    }

}
