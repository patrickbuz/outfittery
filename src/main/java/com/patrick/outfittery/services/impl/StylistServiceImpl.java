package com.patrick.outfittery.services.impl;

import com.patrick.outfittery.dto.StylistDTO;
import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.exceptions.ResourceNotFoundException;
import com.patrick.outfittery.repositories.StylistRepository;
import com.patrick.outfittery.services.StylistService;
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
public class StylistServiceImpl implements StylistService {

	private final StylistRepository stylistRepository;

	@Autowired
	public StylistServiceImpl(StylistRepository stylistRepository) {
		this.stylistRepository = stylistRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<StylistDTO> findAll() {
		List<StylistEntity> stylistEntities = stylistRepository.findAll();
		return stylistEntities.stream().map(StylistDTO::new).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public StylistDTO save(StylistEntity newStylist) {
		return new StylistDTO(stylistRepository.save(newStylist));
	}

	@Override
	@Transactional(readOnly = true)
	public StylistDTO findById(Long id) {
		return new StylistDTO(stylistRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	@Override
	@Transactional
	public StylistDTO saveOrUpdate(StylistEntity newStylist, Long id) {
		return new StylistDTO(stylistRepository.findById(id)
				.map(stylist -> {
					stylist.setName(newStylist.getName());
					stylist.setEmailAddress(newStylist.getEmailAddress());
					stylist.setStatus(newStylist.getStatus());
					return stylistRepository.save(stylist);
				})
				.orElseGet(() -> {
					newStylist.setId(id);
					return stylistRepository.save(newStylist);
				}));
	}
}
