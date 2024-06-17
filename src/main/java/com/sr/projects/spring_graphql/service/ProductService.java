package com.sr.projects.spring_graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.projects.spring_graphql.entity.Product;
import com.sr.projects.spring_graphql.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Update Stocks
    public Product updateStock(int id, int quantity) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        product.setStock(quantity);
        return productRepository.save(product);
    }

    // Update Quantity 
    public Product recieve(int id, int quantity) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        int availableStock = product.getStock();
        product.setStock(availableStock + quantity);
        return productRepository.save(product);
    }
}
