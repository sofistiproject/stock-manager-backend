package com.sofisticat.stockmanagerbackend.dto;

import com.sofisticat.stockmanagerbackend.model.sale.SaleTimeInterval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketSalesInfoDTO {

    private SaleTimeInterval timeInterval;
    private String id;

}
