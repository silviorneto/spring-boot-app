package com.personal.springcourse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.personal.springcourse.entities.CategoryEntity;
import com.personal.springcourse.entities.OrderEntity;
import com.personal.springcourse.entities.UserEntity;
import com.personal.springcourse.entities.enums.OrderStatus;
import com.personal.springcourse.repositores.CategoryRepository;
import com.personal.springcourse.repositores.OrderRepository;
import com.personal.springcourse.repositores.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		UserEntity u1 = new UserEntity(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		UserEntity u2 = new UserEntity(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		OrderEntity o1 = new OrderEntity(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		OrderEntity o2 = new OrderEntity(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		OrderEntity o3 = new OrderEntity(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
		CategoryEntity cat2 = new CategoryEntity(null, "Books");
		CategoryEntity cat3 = new CategoryEntity(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
