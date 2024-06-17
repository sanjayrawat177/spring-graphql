package com.sr.projects.spring_graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.projects.spring_graphql.entity.Product;
import com.sr.projects.spring_graphql.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int quantity) {
        return productService.updateStock(id, quantity);
    }
    
    @MutationMapping
    public Product recieveNewShipment(@Argument int id, @Argument int quantity) {
        return productService.recieve(id, quantity);
    }
}
