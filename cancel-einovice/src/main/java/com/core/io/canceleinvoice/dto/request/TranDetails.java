package com.core.io.canceleinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TranDetails {
        @JsonProperty("TaxSch")
        private String taxSch = "GST";

        @JsonProperty("SupTyp")
        private String supplyType;

        @JsonProperty("RegRev")
        private String regRev = "N";

        @JsonProperty("IgstOnIntra")
        private String igstOnIntra = "N";
}
