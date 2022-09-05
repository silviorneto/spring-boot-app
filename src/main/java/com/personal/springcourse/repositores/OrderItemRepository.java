package com.personal.springcourse.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.springcourse.entities.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
	
}
