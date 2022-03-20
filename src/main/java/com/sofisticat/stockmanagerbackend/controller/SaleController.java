package com.sofisticat.stockmanagerbackend.controller;

import com.sofisticat.stockmanagerbackend.dto.MarketSalesInfoDTO;
import com.sofisticat.stockmanagerbackend.dto.SaleInfoResponseDTO;
import com.sofisticat.stockmanagerbackend.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    // get the market sale info by given time
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<SaleInfoResponseDTO> getMarketSalesInfoByTime(@RequestBody MarketSalesInfoDTO salesInfo) {
        SaleInfoResponseDTO response = saleService.getMarketInfoByTime(salesInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
