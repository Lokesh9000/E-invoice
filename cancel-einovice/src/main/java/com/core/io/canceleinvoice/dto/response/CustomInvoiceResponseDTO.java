package com.core.io.canceleinvoice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomInvoiceResponseDTO {

    private int status;
    private String message;
    private String uuid;

    // For status == 1
    private Integer distance;
    private String EwbDt;
    private Long EwbNo;
    private String EwbValidTill;

    // For both
    private String Irn;
    private String SignedQrCodeImgUrl;
    private String InvoicePdfUrl;
    private String EWayBillPdfUrl;
    private String EWayBillQrCodeUrl;
    private String IrnStatus;
    private String EwbStatus;
    private String Irp;

    // For status == 0
    private Object Data;
    private Integer Status;
    private List<ErrorDetailDTO> ErrorDetails;
    private String DigitallySignedInvoicePdfUrl;
    private String EWayBillBarCodeUrl;
    private String EWayBillPartaSlipPdfUrl;
    private String IrpPortal;
    private String EwbPortal;
}

