package com.sofisticat.stockmanagerbackend.database.sale;

import com.sofisticat.stockmanagerbackend.dto.MarketSalesInfoDTO;
import com.sofisticat.stockmanagerbackend.dto.SaleInfoResponseDTO;

public interface SaleDatabase {
    public SaleInfoResponseDTO getMarketInfoByTime(MarketSalesInfoDTO salesInfo);
}
