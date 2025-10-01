package com.core.io.gst_einvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValDtls {
    @JsonProperty("AssVal")
    private double assVal;           // sum of all AssAmt

    @JsonProperty("CgstVal")
    private double cgstVal;          // sum of all CgstAmt

    @JsonProperty("SgstVal")
    private double sgstVal;          // sum of all SgstAmt

    @JsonProperty("IgstVal")
    private double igstVal;          // sum of all IgstAmt

    @JsonProperty("CesVal")
    private double cesVal;           // sum of all CesAmt

    @JsonProperty("StCesVal")
    private double stCesVal;         // sum of all StateCesAmt

    @JsonProperty("Discount")
    private double discount;         // sum of all Discount

    @JsonProperty("OthChrg")
    private double othChrg;          // sum of all OthChrg

    @JsonProperty("RndOffAmt")
    private double rndOffAmt = 0;    // default

    @JsonProperty("TotInvVal")
    private double totInvVal;        // sum of all TotItemVal
}
