package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.UserEntity;
import com.personal.springcourse.repositores.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserEntity> findAll() {
		return repository.findAll();
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> obj =  repository.findById(id);
		return obj.get();
	}
	
	public UserEntity insert (UserEntity obj) {
		return repository.save(obj);
	}
}
