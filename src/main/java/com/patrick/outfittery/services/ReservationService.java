package com.patrick.outfittery.services;

import com.patrick.outfittery.Reservation;
import com.patrick.outfittery.dto.ReservationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@Service
public interface ReservationService {

	ReservationDTO save(Reservation reservation);

	List<ReservationDTO> findAll();
}
