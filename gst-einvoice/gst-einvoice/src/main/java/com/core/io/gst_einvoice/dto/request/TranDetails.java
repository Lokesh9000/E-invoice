package com.core.io.gst_einvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TranDetails {
        @JsonProperty("TaxSch")
        private String taxSch = "GST";

        @JsonProperty("SupTyp")
        private String supplyType;      // provided by user

        @JsonProperty("RegRev")
        private String regRev = "N";

        @JsonProperty("IgstOnIntra")
        private String igstOnIntra = "N";
}
