package com.personal.springcourse.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.springcourse.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
