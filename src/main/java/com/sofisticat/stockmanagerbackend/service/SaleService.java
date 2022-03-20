package com.sofisticat.stockmanagerbackend.service;

import com.sofisticat.stockmanagerbackend.database.sale.SaleManager;
import com.sofisticat.stockmanagerbackend.dto.MarketSalesInfoDTO;
import com.sofisticat.stockmanagerbackend.dto.SaleInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleManager saleManager;

    public SaleInfoResponseDTO getMarketInfoByTime(MarketSalesInfoDTO salesInfo) {
        return saleManager.getMarketInfoByTime(salesInfo);
    }
}
