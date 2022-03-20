package com.sofisticat.stockmanagerbackend.database.sale;

import com.sofisticat.stockmanagerbackend.dto.MarketSalesInfoDTO;
import com.sofisticat.stockmanagerbackend.dto.SaleInfoResponseDTO;
import com.sofisticat.stockmanagerbackend.model.product.Product;
import com.sofisticat.stockmanagerbackend.model.product.ProductDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SaleManager implements SaleDatabase {

    public SaleInfoResponseDTO getMarketInfoByTime(MarketSalesInfoDTO salesInfo) {
        Product p1 = new Product(UUID.randomUUID().toString(),
                "Test Product-1",
                4.55,
                new ProductDetail(25));
        Product p2 = new Product(UUID.randomUUID().toString(),
                "Test Product-2",
                35.55,
                new ProductDetail( 500));
        return new SaleInfoResponseDTO("test", List.of(p1, p2));
    }
}
