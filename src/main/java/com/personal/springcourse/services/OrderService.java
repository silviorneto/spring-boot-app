package com.personal.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.springcourse.entities.OrderEntity;
import com.personal.springcourse.repositores.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<OrderEntity> findAll(){
		return repository.findAll();
	}
	
	public OrderEntity findById(Long id){
		Optional<OrderEntity> order = repository.findById(id);
		return order.get();
	}
}
