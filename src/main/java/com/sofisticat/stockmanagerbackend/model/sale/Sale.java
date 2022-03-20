package com.sofisticat.stockmanagerbackend.model.sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sale {

    @JsonProperty
    String id;
    @JsonProperty
    SaleDetail details;
}
