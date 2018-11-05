package com.patrick.outfittery.controllers;

import com.patrick.outfittery.dto.StylistDTO;
import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.model.StylistStatusEnum;
import com.patrick.outfittery.services.StylistService;
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
public class StylistController {

	private final StylistService stylistService;

	@Autowired
	public StylistController(StylistService stylistService) {
		this.stylistService = stylistService;
	}

	@GetMapping("/stylist")
	public List<StylistDTO> findAll() {
		return stylistService.findAll();
	}

	@PostMapping("/stylist")
	public StylistDTO addStylist(@RequestBody StylistEntity newStylist) {
		return stylistService.save(newStylist);
	}

	@GetMapping("/stylist/{id}")
	public StylistDTO findById(@PathVariable Long id) {
		return stylistService.findById(id);
	}

	@PutMapping("/stylist/{id}")
	public StylistDTO saveOrUpdate(@RequestBody StylistEntity newStylist, @PathVariable Long id) {
		return stylistService.saveOrUpdate(newStylist, id);
	}

	@GetMapping("/stylist/default")
	public void initTable() {
		StylistEntity s1 = new StylistEntity();
		s1.setEmailAddress("patrick@outfittery.com");
		s1.setName("Patrick");
		s1.setStatus(StylistStatusEnum.ROOKIE);
		StylistEntity s2 = new StylistEntity();
		s2.setEmailAddress("nico@outfittery.com");
		s2.setName("Nico");
		s2.setStatus(StylistStatusEnum.READY);
		stylistService.save(s1);
		stylistService.save(s2);
	}
}
