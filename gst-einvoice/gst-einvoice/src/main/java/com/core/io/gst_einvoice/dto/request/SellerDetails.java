package com.core.io.gst_einvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SellerDetails {
    @JsonProperty("Gstin")
    private String gstin;           // provided by user

    @JsonProperty("LglNm")
    private String lglNm;           // provided by user

    @JsonProperty("Addr1")
    private String addr1;           // provided by user

    @JsonProperty("Loc")
    private String loc;             // provided by user

    @JsonProperty("Pin")
    private Integer pin;            // provided by user

    @JsonProperty("Stcd")
    private String stcd;            // provided by user
}
