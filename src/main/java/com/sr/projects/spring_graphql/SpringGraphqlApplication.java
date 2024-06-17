package com.sr.projects.spring_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sr.projects.spring_graphql.entity.Product;
import com.sr.projects.spring_graphql.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringGraphqlApplication {

	@Autowired
	private ProductRepository productRepository;

	// @PostConstruct
	// public void initTestDB() {
	// 	productRepository.saveAll(List.of(
	// 	new Product("Samsung", "Electronics", 100.28f, 100), 
	// 	new Product("Mixer", "Electronics", 50.50f, 100), 
	// 	new Product("Pants", "Cloths", 13.28f, 100), 
	// 	new Product("Batman", "Toys", 70.2f, 100), 
	// 	new Product("Milk", "Grocery", 10.08f, 100)
	// 	));

	// }

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphqlApplication.class, args);
	}

}
