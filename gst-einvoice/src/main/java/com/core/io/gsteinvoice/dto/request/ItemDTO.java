package com.core.io.gsteinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemDTO {
    @JsonProperty("ItemNo")
    private int itemNo = 0;

    @JsonProperty("SlNo")
    private String slNo;             // provided by user

    @JsonProperty("IsServc")
    private String isServc = "N";

    @JsonProperty("PrdDesc")
    private String prdDesc;          // provided by user

    @JsonProperty("HsnCd")
    private String hsnCd;            // provided by user

    @JsonProperty("Qty")
    private int qty;                 // provided by user

    @JsonProperty("FreeQty")
    private int freeQty = 0;

    @JsonProperty("Unit")
    private String unit;             // provided by user

    @JsonProperty("UnitPrice")
    private double unitPrice;        // provided by user

    @JsonProperty("TotAmt")
    private double totAmt;           // calculated

    @JsonProperty("Discount")
    private double discount = 0;     // provided by user or default

    @JsonProperty("PreTaxVal")
    private double preTaxVal = 0;

    @JsonProperty("AssAmt")
    private double assAmt;

    @JsonProperty("GstRt")
    private double gstRt;

    @JsonProperty("IgstAmt")
    private double igstAmt;

    @JsonProperty("CgstAmt")
    private double cgstAmt = 0;

    @JsonProperty("SgstAmt")
    private double sgstAmt = 0;

    @JsonProperty("CesRt")
    private double cesRt = 0;

    @JsonProperty("CesAmt")
    private double cesAmt = 0;

    @JsonProperty("CesNonAdvlAmt")
    private double cesNonAdvlAmt = 0;

    @JsonProperty("StateCesRt")
    private double stateCesRt = 0;

    @JsonProperty("StateCesAmt")
    private double stateCesAmt = 0;

    @JsonProperty("StateCesNonAdvlAmt")
    private double stateCesNonAdvlAmt = 0;

    @JsonProperty("OthChrg")
    private double othChrg = 0;      // provided by user or default

    @JsonProperty("TotItemVal")
    private double totItemVal;       // calculated
}
