package com.core.io.canceleinvoice.controller;

import com.core.io.canceleinvoice.dto.request.InvoiceRequestDTO;
import com.core.io.canceleinvoice.dto.response.CustomInvoiceResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.core.io.canceleinvoice.service.*;

@RestController
@RequestMapping("/api/einvoices")
@RequiredArgsConstructor
public class CancelInvoiceController {
    private final CancelEinvoiceServiceImp invoiceService;
    @PostMapping("/cancel")
    public ResponseEntity<CustomInvoiceResponseDTO> generateAndPost(@RequestBody InvoiceRequestDTO request) {
        CustomInvoiceResponseDTO response = invoiceService.generateAndPostInvoice(request);
        return ResponseEntity.ok(response);
    }
}
