package com.personal.springcourse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.springcourse.entities.UserEntity;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<UserEntity> findAll() {
		UserEntity u = new UserEntity(1L, "Maria", "maria@gmail.com", "99999-9999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
