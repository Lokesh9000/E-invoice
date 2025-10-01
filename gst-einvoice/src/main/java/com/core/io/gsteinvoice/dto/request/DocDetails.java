package com.core.io.gsteinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocDetails {
    @JsonProperty("Typ")
    private String typ = "INV";

    @JsonProperty("No")
    private String no;

    @JsonProperty("Dt")
    private String dt;
}
