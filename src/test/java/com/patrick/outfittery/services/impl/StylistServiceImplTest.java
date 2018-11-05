package com.patrick.outfittery.services.impl;

import com.patrick.outfittery.dto.StylistDTO;
import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.exceptions.ResourceNotFoundException;
import com.patrick.outfittery.model.StylistStatusEnum;
import com.patrick.outfittery.repositories.StylistRepository;
import com.sun.tools.javac.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@RunWith(MockitoJUnitRunner.class)
public class StylistServiceImplTest {

	@Mock
	private StylistRepository stylistRepository;

	@InjectMocks
	private StylistServiceImpl stylistService;

	@Test
	public void findAll() {
		when(stylistRepository.findAll()).thenReturn(List.of(new StylistEntity(), new StylistEntity()));
		Assert.assertEquals(stylistService.findAll().size(), 2);
	}

	@Test
	public void findById() {
		StylistEntity stylist = new StylistEntity();
		stylist.setName("John Smith");
		stylist.setStatus(StylistStatusEnum.OFFBOARDED);
		Optional<StylistEntity> stylistEntity = Optional.of(stylist);
		when(stylistRepository.findById(anyLong())).thenReturn(stylistEntity);
		StylistDTO stylistDTO = stylistService.findById(anyLong());
		Assert.assertTrue("John Smith".equals(stylistDTO.getName()));
		Assert.assertTrue(StylistStatusEnum.OFFBOARDED == stylistDTO.getStatus());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void findByIdThrowsResourceNotFoundException() {
		when(stylistRepository.findById(anyLong())).thenReturn(Optional.empty());
		stylistService.findById(anyLong());
	}
}
