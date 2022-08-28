package com.personal.springcourse.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.springcourse.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
