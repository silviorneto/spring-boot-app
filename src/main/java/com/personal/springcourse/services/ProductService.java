package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.ProductEntity;
import com.personal.springcourse.repositores.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductEntity> findAll() {
		return repository.findAll();
	}
	
	public ProductEntity findById(Long id) {
		Optional<ProductEntity> obj = repository.findById(id);
		return obj.get();
	}
}
