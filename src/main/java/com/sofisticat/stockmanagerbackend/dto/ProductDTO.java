package com.sofisticat.stockmanagerbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sofisticat.stockmanagerbackend.model.product.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @JsonProperty
    private String name;
    @JsonProperty
    private double price;
    @JsonProperty
    private ProductDetail details;

}
