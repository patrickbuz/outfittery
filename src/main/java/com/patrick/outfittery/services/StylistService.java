package com.patrick.outfittery.services;

import com.patrick.outfittery.dto.StylistDTO;
import com.patrick.outfittery.entities.StylistEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Service
public interface StylistService {

	List<StylistDTO> findAll();

	StylistDTO save(StylistEntity newStylist);

	StylistDTO findById(Long id);

	StylistDTO saveOrUpdate(StylistEntity newStylist, Long id);

}
