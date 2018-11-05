package com.patrick.outfittery.services.impl;

import com.patrick.outfittery.dto.CustomerDTO;
import com.patrick.outfittery.entities.CustomerEntity;
import com.patrick.outfittery.exceptions.ResourceNotFoundException;
import com.patrick.outfittery.repositories.CustomerRepository;
import com.patrick.outfittery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerDTO> findAll() {
		return customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public CustomerDTO save(CustomerEntity customerEntity) {
		return new CustomerDTO(customerRepository.save(customerEntity));
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerDTO findById(Long id) {
		return new CustomerDTO(customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	@Override
	@Transactional
	public CustomerDTO saveOrUpdate(CustomerEntity newCustomer, Long id) {
		return new CustomerDTO(customerRepository.findById(id)
				.map(customer -> {
					customer.setEmailAddress(newCustomer.getEmailAddress());
					customer.setName(newCustomer.getName());
					return customerRepository.save(customer);
				}).orElseGet(() -> {
					newCustomer.setId(id);
					return customerRepository.save(newCustomer);
				}));
	}
}
