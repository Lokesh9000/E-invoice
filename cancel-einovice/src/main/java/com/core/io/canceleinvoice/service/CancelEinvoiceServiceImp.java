package com.core.io.canceleinvoice.service;

import com.core.io.canceleinvoice.dto.request.InvoiceRequestDTO;
import com.core.io.canceleinvoice.dto.request.ItemDTO;
import com.core.io.canceleinvoice.dto.request.ValDtls;
import com.core.io.canceleinvoice.dto.response.CustomInvoiceResponseDTO;
import com.core.io.canceleinvoice.dto.response.GstZenResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Service
public class CancelEinvoiceServiceImp {

    private final RestTemplate restTemplate;

    private static final String GSTZEN_URL =
            "https://my.gstzen.in/~gstzen/a/post-einvoice-data/einvoice-json/cancel/";

    private static final String TOKEN_KEY = "de3a3a01-273a-4a81-8b75-13fe37f14dc6";

    public CancelEinvoiceServiceImp(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    public CustomInvoiceResponseDTO generateAndPostInvoice(InvoiceRequestDTO invoice){

        // public GstZenResponseDTO generateAndPostInvoice(InvoiceRequestDTO invoice) {
        String sellerState = invoice.getSellerDtls().getStcd();
        String buyerState = invoice.getBuyerDtls().getStcd();

        for (ItemDTO item : invoice.getItemList()) {
            calculateItemValues(item, sellerState, buyerState);
        }

        ValDtls totals = new ValDtls();
        BigDecimal assVal = BigDecimal.ZERO;
        BigDecimal cgstVal = BigDecimal.ZERO;
        BigDecimal sgstVal = BigDecimal.ZERO;
        BigDecimal igstVal = BigDecimal.ZERO;
        BigDecimal cesVal = BigDecimal.ZERO;
        BigDecimal stCesVal = BigDecimal.ZERO;
        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal othChrg = BigDecimal.ZERO;
        BigDecimal totInv = BigDecimal.ZERO;

        for (ItemDTO item : invoice.getItemList()) {
            assVal = assVal.add(BigDecimal.valueOf(item.getAssAmt()));
            cgstVal = cgstVal.add(BigDecimal.valueOf(item.getCgstAmt()));
            sgstVal = sgstVal.add(BigDecimal.valueOf(item.getSgstAmt()));
            igstVal = igstVal.add(BigDecimal.valueOf(item.getIgstAmt()));
            cesVal = cesVal.add(BigDecimal.valueOf(item.getCesAmt()));
            stCesVal = stCesVal.add(BigDecimal.valueOf(item.getStateCesAmt()));
            discount = discount.add(BigDecimal.valueOf(item.getDiscount()));
            othChrg = othChrg.add(BigDecimal.valueOf(item.getOthChrg()));
            totInv = totInv.add(BigDecimal.valueOf(item.getTotItemVal()));
        }

        totals.setAssVal(assVal.doubleValue());
        totals.setCgstVal(cgstVal.doubleValue());
        totals.setSgstVal(sgstVal.doubleValue());
        totals.setIgstVal(igstVal.doubleValue());
        totals.setCesVal(cesVal.doubleValue());
        totals.setStCesVal(stCesVal.doubleValue());
        totals.setDiscount(discount.doubleValue());
        totals.setOthChrg(othChrg.doubleValue());
        totals.setRndOffAmt(0d);
        totals.setTotInvVal(totInv.doubleValue());
        invoice.setValDtls(totals);

        try {
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            String jsonPayload = mapper.writeValueAsString(invoice);
            System.out.println(">>> GSTZen Request Payload >>>\n" + jsonPayload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Token", TOKEN_KEY);

        HttpEntity<InvoiceRequestDTO> requestEntity = new HttpEntity<>(invoice, headers);

        ResponseEntity<GstZenResponseDTO> response = restTemplate.exchange(
                GSTZEN_URL,
                HttpMethod.POST,
                requestEntity,
                GstZenResponseDTO.class
        );

        if (!response.getStatusCode().is2xxSuccessful()) {
            log.error("GSTZen API error: HTTP {} body={}", response.getStatusCodeValue(), response.getBody());
            throw new RuntimeException("GSTZen API error: " + response.getStatusCode());
        }

        GstZenResponseDTO gstZenResponse = response.getBody();


        CustomInvoiceResponseDTO custom = new CustomInvoiceResponseDTO();
        custom.setStatus(gstZenResponse.getStatus());
        custom.setMessage(gstZenResponse.getMessage());
        custom.setUuid(gstZenResponse.getUuid());
        custom.setIrn(gstZenResponse.getIrn());
        custom.setSignedQrCodeImgUrl(gstZenResponse.getSignedQrCodeImgUrl());
        custom.setInvoicePdfUrl(gstZenResponse.getInvoicePdfUrl());
        custom.setEWayBillPdfUrl(gstZenResponse.getEwayBillPdfUrl());
        custom.setEWayBillQrCodeUrl(gstZenResponse.getEwayBillQrCodeUrl());
        custom.setIrnStatus(gstZenResponse.getIrnStatus());
        custom.setEwbStatus(gstZenResponse.getEwbStatus());
        custom.setIrp(gstZenResponse.getIrp());

        if (gstZenResponse.getStatus() == 0) {
            custom.setData(gstZenResponse.getData());
            custom.setStatus(gstZenResponse.getStatus());  // optional, if needed again
            custom.setErrorDetails(gstZenResponse.getErrorDetails());
            custom.setDigitallySignedInvoicePdfUrl(gstZenResponse.getDigitallySignedInvoicePdfUrl());
            custom.setEWayBillBarCodeUrl(gstZenResponse.getEwayBillBarCodeUrl());
            custom.setEWayBillPartaSlipPdfUrl(gstZenResponse.getEwayBillPartaSlipPdfUrl());
            custom.setIrpPortal(gstZenResponse.getIrpPortal());
            custom.setEwbPortal(gstZenResponse.getEwbPortal());
        }else if (gstZenResponse.getStatus() == 1) {
            custom.setDistance(1300);
            custom.setEwbDt("2023-08-28 17:30:00");
            custom.setEwbNo(111010260897L);
            custom.setEwbValidTill("2023-09-04 23:59:00");
        }
        log.info("Successfully posted e-invoice; response={}", gstZenResponse);
        return custom;
    }

    private void calculateItemValues(ItemDTO item, String sellerState, String buyerState) {
        BigDecimal qty = BigDecimal.valueOf(item.getQty());
        BigDecimal unitPrice = BigDecimal.valueOf(item.getUnitPrice());
        BigDecimal totAmt = qty.multiply(unitPrice);
        item.setTotAmt(totAmt.doubleValue());

        BigDecimal assAmt = totAmt
                .subtract(BigDecimal.valueOf(item.getDiscount()))
                .add(BigDecimal.valueOf(item.getPreTaxVal()));
        item.setAssAmt(assAmt.doubleValue());

        BigDecimal totalGstAmt = assAmt
                .multiply(BigDecimal.valueOf(item.getGstRt()))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        boolean interState = !sellerState.equals(buyerState);
        if (interState) {
            item.setIgstAmt(totalGstAmt.doubleValue());
            item.setCgstAmt(0d);
            item.setSgstAmt(0d);
        } else {
            BigDecimal half = totalGstAmt.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
            item.setCgstAmt(half.doubleValue());
            item.setSgstAmt(half.doubleValue());
            item.setIgstAmt(0d);
        }

        BigDecimal cesAmt = assAmt.multiply(BigDecimal.valueOf(item.getCesRt()))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        BigDecimal stCesAmt = assAmt.multiply(BigDecimal.valueOf(item.getStateCesRt()))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        item.setCesAmt(cesAmt.doubleValue());
        item.setStateCesAmt(stCesAmt.doubleValue());

        BigDecimal totItemVal = assAmt
                .add(BigDecimal.valueOf(item.getIgstAmt()))
                .add(BigDecimal.valueOf(item.getCgstAmt()))
                .add(BigDecimal.valueOf(item.getSgstAmt()))
                .add(cesAmt)
                .add(stCesAmt)
                .add(BigDecimal.valueOf(item.getOthChrg()));
        item.setTotItemVal(totItemVal.doubleValue());
    }
}

