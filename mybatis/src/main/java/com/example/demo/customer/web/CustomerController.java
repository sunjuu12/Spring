package com.example.demo.customer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/customer")
	//@ResponseBody //restController일 땐 안 써도 됨
	public Iterable<Customer> customer() {
		return repo.findAll();
	}
	
	// 등록
	// localhost/regCustomer?fname=dong&lname=choi
	@GetMapping("/regCustomer")
	public Customer regCustomer(String fname, String lname) {
		return repo.save(new Customer(fname, lname));
	}
	
	// find
	@GetMapping("/findCustomer/{firstName}")
	public List<Customer> findCustomer(@PathVariable String firstName) {
		return repo.findByfirstName(firstName);
	}
}
