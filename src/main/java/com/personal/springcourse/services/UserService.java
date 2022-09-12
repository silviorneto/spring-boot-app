package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.UserEntity;
import com.personal.springcourse.repositores.UserRepository;
import com.personal.springcourse.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserEntity> findAll() {
		return repository.findAll();
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public UserEntity insert (UserEntity obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	public UserEntity update(Long id, UserEntity obj) {
		// getOne => Não vai no banco de dados ainda, deixa o objeto monitorado pelo JPA
		UserEntity entity = repository.getOne(id); 
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(UserEntity entity, UserEntity obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
}
