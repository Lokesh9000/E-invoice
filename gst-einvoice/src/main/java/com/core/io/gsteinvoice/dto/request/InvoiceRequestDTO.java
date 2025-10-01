package com.core.io.gsteinvoice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InvoiceRequestDTO {
    @JsonProperty("Version")
    private String version = "1.1";

    @JsonProperty("TranDtls")
    private TranDetails tranDtls = new TranDetails();

    @JsonProperty("DocDtls")
    private DocDetails docDtls = new DocDetails();

    @JsonProperty("SellerDtls")
    private SellerDetails sellerDtls = new SellerDetails();

    @JsonProperty("BuyerDtls")
    private BuyerDetails buyerDtls = new BuyerDetails();;

    @JsonProperty("DispDtls")
    private DispDetails dispDtls = new DispDetails();;

    @JsonProperty("ShipDtls")
    private ShipDetails shipDtls = new ShipDetails();;

    @JsonProperty("ItemList")
    private List<ItemDTO> itemList= new ArrayList<>();;

    @JsonProperty("ValDtls")
    private ValDtls valDtls = new ValDtls();
}
