package com.sofisticat.stockmanagerbackend.service;

import com.sofisticat.stockmanagerbackend.database.product.ProductManager;
import com.sofisticat.stockmanagerbackend.dto.ProductDTO;
import com.sofisticat.stockmanagerbackend.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductManager productManager;

    public int insertProduct(@RequestBody ProductDTO productDTO) {
        return productManager.insertProduct(productDTO);
    }

    public Optional<Product> findProductById(String uuid) {
        return productManager.findProductById(uuid);
    }
}
