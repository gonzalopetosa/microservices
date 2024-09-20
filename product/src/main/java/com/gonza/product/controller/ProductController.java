package com.gonza.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gonza.product.entity.ProductEntity;
import com.gonza.product.repository.ProductRepository;

import java.util.List;


@Controller
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/getAll")
	public ResponseEntity<List<ProductEntity>> getAll() 
	{
		List<ProductEntity> productEntities = productRepository.findAll();
		return ResponseEntity.ok(productEntities) ;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductEntity productEntity){
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productEntity)) ;
	}
	
	
}
