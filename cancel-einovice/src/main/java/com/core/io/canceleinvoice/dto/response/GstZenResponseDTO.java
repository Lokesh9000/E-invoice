package com.core.io.canceleinvoice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GstZenResponseDTO {

    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("Data")
    private Object data;

    @JsonProperty("Status")
    private int Status;

    @JsonProperty("InfoDtls")
    private Object infoDtls;

    @JsonProperty("ErrorDetails")
    private List<ErrorDetailDTO> errorDetails;

    @JsonProperty("Irn")
    private String irn;

    @JsonProperty("SignedQrCodeImgUrl")
    private String signedQrCodeImgUrl;

    @JsonProperty("InvoicePdfUrl")
    private String invoicePdfUrl;

    @JsonProperty("EWayBillPdfUrl")
    private String ewayBillPdfUrl;

    @JsonProperty("EWayBillQrCodeUrl")
    private String ewayBillQrCodeUrl;

    @JsonProperty("DigitallySignedInvoicePdfUrl")
    private String digitallySignedInvoicePdfUrl;

    @JsonProperty("EWayBillBarCodeUrl")
    private String ewayBillBarCodeUrl;

    @JsonProperty("EWayBillPartaSlipPdfUrl")
    private String ewayBillPartaSlipPdfUrl;

    @JsonProperty("IrnStatus")
    private String irnStatus;

    @JsonProperty("EwbStatus")
    private String ewbStatus;

    @JsonProperty("Irp")
    private String irp;

    @JsonProperty("IrpPortal")
    private String irpPortal;

    @JsonProperty("EwbPortal")
    private String ewbPortal;

    @JsonProperty("EwbDt")
    private String ewbDt;

    @JsonProperty("EwbValidTill")
    private String ewbValidTill;

    @JsonProperty("EwbNo")
    private Long ewbNo;
}
