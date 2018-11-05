package com.patrick.outfittery.services;

import com.patrick.outfittery.dto.CustomerDTO;
import com.patrick.outfittery.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Service
public interface CustomerService {

	List<CustomerDTO> findAll();

	CustomerDTO save(CustomerEntity customerEntity);

	CustomerDTO findById(Long id);

	CustomerDTO saveOrUpdate(CustomerEntity customerEntity, Long id);
}
