package com.personal.springcourse.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.springcourse.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
}
