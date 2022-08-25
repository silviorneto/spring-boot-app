package com.personal.springcourse.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.springcourse.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>  {

}
