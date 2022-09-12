package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.UserEntity;
import com.personal.springcourse.repositores.UserRepository;
import com.personal.springcourse.services.exceptions.DatabaseException;
import com.personal.springcourse.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserEntity> findAll() {
		return repository.findAll();
	}

	public UserEntity findById(Long id) {
		Optional<UserEntity> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public UserEntity insert(UserEntity obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public UserEntity update(Long id, UserEntity obj) {
		try {
			// getOne => Não vai no banco de dados ainda, deixa o objeto monitorado pelo JPA
			UserEntity entity = repository.getOne(id); 
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(UserEntity entity, UserEntity obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
