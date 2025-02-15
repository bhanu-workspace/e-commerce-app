package com.product_service.service;


import com.product_service.dao.ProductRepository;
import com.product_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProducts(Product product){
       return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProduct(Long productId){
        return productRepository.findById(productId).stream().toList();
    }

    public String deleteProduct(Long productId){
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return "Product Deleted";
        } else {
            return "Product not found";
        }
    }
}
