package com.core.io.gsteinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DispDetails {
    @JsonProperty("Nm")
    private String name;

    @JsonProperty("Addr1")
    private String addr1;

    @JsonProperty("Loc")
    private String loc;

    @JsonProperty("Pin")
    private Integer pin;

    @JsonProperty("Stcd")
    private String stcd;
}
