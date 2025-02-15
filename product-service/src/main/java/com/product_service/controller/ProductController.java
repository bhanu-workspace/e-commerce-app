package com.product_service.controller;

import com.product_service.entity.Product;
import com.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public List<Product> getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/products")
    public Product addProducts(@RequestBody Product product){
       return productService.saveProducts(product);
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
}
