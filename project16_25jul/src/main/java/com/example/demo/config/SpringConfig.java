package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SpringConfig implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("abc", "abc@email.com"));
		customers.add(new Customer("efg", "efg@email.com"));
		customers.add(new Customer("ijk", "ijk@email.com"));
		customerRepository.saveAll(customers);
	}
}
