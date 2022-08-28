package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.CategoryEntity;
import com.personal.springcourse.repositores.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryEntity> findAll() {
		return repository.findAll();
	}
	
	public CategoryEntity findById(Long id) {
		Optional<CategoryEntity> obj = repository.findById(id);
		return obj.get();
	}
	
}
