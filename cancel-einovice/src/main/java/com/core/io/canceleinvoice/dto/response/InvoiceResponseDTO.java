package com.core.io.canceleinvoice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status", "message", "Irn", "AckDt", "AckNo", "EwbDt", "EwbNo", "Status", "Remarks",
        "AckNoStr", "InfoDtls", "EwbValidTill", "SignedQRCode", "SignedInvoice", "uuid",
        "SignedQrCodeImgUrl", "InvoicePdfUrl", "DigitallySignedInvoicePdfUrl", "EWayBillPdfUrl",
        "EWayBillQrCodeUrl", "EWayBillPartaSlipPdfUrl", "IrnStatus", "EwbStatus",
        "Irp", "IrpPortal", "EwbPortal"
})
public class  InvoiceResponseDTO {
    private int status;
    private String message;
    private String Irn;
    private String AckDt;
    private Long AckNo;
    private String EwbDt;
    private String EwbNo;
    private String Status;
    private String Remarks;
    private String AckNoStr;
    private Object InfoDtls;
    private String EwbValidTill;
    private String SignedQRCode;
    private String SignedInvoice;
    private String uuid;
    private String SignedQrCodeImgUrl;
    private String InvoicePdfUrl;
    private String DigitallySignedInvoicePdfUrl;
    private String EWayBillPdfUrl;
    private String EWayBillQrCodeUrl;
    private String EWayBillPartaSlipPdfUrl;
    private String IrnStatus;
    private String EwbStatus;
    private String Irp;
    private String IrpPortal;
    private String EwbPortal;
}
