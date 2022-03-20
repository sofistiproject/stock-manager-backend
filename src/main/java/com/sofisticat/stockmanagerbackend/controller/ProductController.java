package com.sofisticat.stockmanagerbackend.controller;

import com.sofisticat.stockmanagerbackend.dto.ProductDTO;
import com.sofisticat.stockmanagerbackend.model.product.Product;
import com.sofisticat.stockmanagerbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;


    // insert a product
    @PostMapping
    public ResponseEntity<Integer> insertProduct(@RequestBody ProductDTO productDTO) {
        int rowCount = productService.insertProduct(productDTO);
        return new ResponseEntity<>(rowCount, HttpStatus.OK);
    }

    // get a product info
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
        Optional<Product> productById = productService.findProductById(productId);
        return productById
            .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }
    // get all products from market
    // update a product
    // delete a product
}
