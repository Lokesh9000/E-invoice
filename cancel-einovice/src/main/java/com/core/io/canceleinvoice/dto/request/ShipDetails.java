package com.core.io.canceleinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShipDetails {
    @JsonProperty("Gstin")
    private String gstin;

    @JsonProperty("LglNm")
    private String lglNm;

    @JsonProperty("Addr1")
    private String addr1;

    @JsonProperty("Loc")
    private String loc;

    @JsonProperty("Pin")
    private Integer pin;

    @JsonProperty("Stcd")
    private String stcd;
}
