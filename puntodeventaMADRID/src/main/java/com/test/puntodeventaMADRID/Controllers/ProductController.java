package com.test.puntodeventaMADRID.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.puntodeventaMADRID.Exceptions.ExceptionNotFound;
import com.test.puntodeventaMADRID.JPA.ProductRepository;
import com.test.puntodeventaMADRID.Models.Product;


@RestController
public class ProductController {
	private ProductRepository productRepository;
	
	
	

	public ProductController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@GetMapping(path = "/products")
	public List<Product> getAllClients(){
		List<Product> clients = productRepository.findAll();
		return clients;
	}
	
	@GetMapping(path = "/products/{id}")
	public Optional<Product> getClientById(@PathVariable int id){
		Optional<Product> client = productRepository.findById(id);
		if(client.isEmpty()) {
			throw new ExceptionNotFound("*****************Product not found**************");
		}
		return client;
	}
	
	@PostMapping("/products")
	public ResponseEntity addUser(@Valid @RequestBody Product client) {
		
		productRepository.save(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/products/{id}")
	public void updateUserByID(@PathVariable int id, @Valid @RequestBody Product product) {
		Optional<Product> productInDb = productRepository.findById(id);
		
		if(productInDb.isEmpty()) {
			throw new ExceptionNotFound("product not found");
		}
		
		productInDb.get().setProductName(product.getProductName());
	}
	
	
	@DeleteMapping("/products/{id}")
	public void deleteUserById(@PathVariable int id) {
		Optional<Product> productInDb = productRepository.findById(id);
		
		if(productInDb.isEmpty()) {
			throw new ExceptionNotFound("product not found");
		}
		productRepository.deleteById(id);
	}
}
