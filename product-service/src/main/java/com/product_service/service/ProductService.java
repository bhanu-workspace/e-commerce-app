package com.product_service.service;


import com.product_service.dao.ProductRepository;
import com.product_service.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public Product updateProduct(Long productId, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Update fields (only update non-null values)
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            // Add other fields as necessary

            return productRepository.save(existingProduct); // Save and return updated product
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
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
