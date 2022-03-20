package com.sofisticat.stockmanagerbackend.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @JsonProperty
    String id;

    @JsonProperty
    String name;

    @JsonProperty
    double price;

    @JsonProperty
    ProductDetail details;

}
