package com.product_service.controller;

import com.product_service.entity.Product;
import com.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

//    @GetMapping
//    public List<Product> getProducts(@RequestParam int page, @RequestParam int size){
//        return productService.getProducts(PageRequest.of(page, size));
//    }

    @GetMapping("/{productId}")
    public List<Product> getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public Product addProducts(@RequestBody Product product){
       return productService.saveProducts(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
}
