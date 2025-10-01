package com.core.io.gst_einvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocDetails {
    @JsonProperty("Typ")
    private String typ = "INV";

    @JsonProperty("No")
    private String no;              // provided by user

    @JsonProperty("Dt")
    private String dt;              // provided by user, dd/MM/yyyy
}
