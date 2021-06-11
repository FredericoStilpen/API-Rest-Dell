package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;

@Service
public class ProductService {

	@Autowired
	public ProductsRepository productRepository;

	public Products findById(Integer prodId) {
		return productRepository.findById(prodId).get();
	}

	public List<Products> findAll() {
		return productRepository.findAll();
	}

	public Long count() {
		return productRepository.count();
	}

	public Products save(Products product) {
		return productRepository.save(product);
	}

	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	public Products update(Products product, Integer id) {
		product.setProdId(id);
		return productRepository.save(product);
	}

}
