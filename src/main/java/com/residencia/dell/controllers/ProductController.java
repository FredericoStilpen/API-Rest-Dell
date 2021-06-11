package com.residencia.dell.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductService;

@RestController // Torna a classe um endpoint válido.
@RequestMapping("/products") // Informa a URL a qual o controller está associado.
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("{/id}") // Por que entre chaves ?
	public ResponseEntity<Products> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();// Response Entity, Httpheaders ???
		return new ResponseEntity<>(productService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<List<Products>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return productService.count();
	}

	@PostMapping
	public ResponseEntity<Products> save(@RequestBody Products product) {

		HttpHeaders headers = new HttpHeaders();

		Products newProduct = productService.save(product);

		if (null != newProduct)
			return new ResponseEntity<>(newProduct, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newProduct, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public Products update(Products product, Integer id) {
		return productService.update(product, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		productService.deleteById(id);
	}

}
