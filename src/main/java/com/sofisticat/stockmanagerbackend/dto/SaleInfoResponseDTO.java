package com.sofisticat.stockmanagerbackend.dto;

import com.sofisticat.stockmanagerbackend.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleInfoResponseDTO {
    private String marketId;
    private List<Product> products;
}
