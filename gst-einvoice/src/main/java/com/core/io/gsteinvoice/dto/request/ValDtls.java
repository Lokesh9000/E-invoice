package com.core.io.gsteinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValDtls {
    @JsonProperty("AssVal")
    private double assVal;

    @JsonProperty("CgstVal")
    private double cgstVal;

    @JsonProperty("SgstVal")
    private double sgstVal;

    @JsonProperty("IgstVal")
    private double igstVal;

    @JsonProperty("CesVal")
    private double cesVal;

    @JsonProperty("StCesVal")
    private double stCesVal;

    @JsonProperty("Discount")
    private double discount;

    @JsonProperty("OthChrg")
    private double othChrg;

    @JsonProperty("RndOffAmt")
    private double rndOffAmt = 0;

    @JsonProperty("TotInvVal")
    private double totInvVal;
}
