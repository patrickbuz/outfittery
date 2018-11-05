package com.patrick.outfittery.controllers;

import com.patrick.outfittery.dto.CustomerDTO;
import com.patrick.outfittery.entities.CustomerEntity;
import com.patrick.outfittery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@RestController
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public List<CustomerDTO> findAll() {
		return customerService.findAll();
	}

	@PostMapping("/customer")
	public CustomerDTO save(@RequestBody CustomerEntity customer) {
		return customerService.save(customer);
	}

	@GetMapping("/customer/{id}")
	public CustomerDTO findById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PutMapping("/customer/{id}")
	public CustomerDTO saveOrUpdate(@RequestBody CustomerEntity customer, @PathVariable Long id) {
		return customerService.saveOrUpdate(customer, id);
	}

	@GetMapping("/customer/default")
	public void initTable() {
		CustomerEntity c1 = new CustomerEntity();
		c1.setEmailAddress("cata@outfittery.com");
		c1.setName("Catalina");
		CustomerEntity c2 = new CustomerEntity();
		c2.setEmailAddress("lau@outfittery.com");
		c2.setName("Lau");
		customerService.save(c1);
		customerService.save(c2);
	}
}
