package com.patrick.outfittery.controllers;

import com.patrick.outfittery.Reservation;
import com.patrick.outfittery.dto.ReservationDTO;
import com.patrick.outfittery.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@RestController
public class ReservationController {

	private final ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@PostMapping("/reservation")
	public List<ReservationDTO> save(@RequestBody List<Reservation> reservation) {
		List<ReservationDTO> reservations = new ArrayList<>();
		reservation.forEach(item -> reservations.add(reservationService.save(item)));
		return reservations;
	}

	@GetMapping("/reservation")
	public List<ReservationDTO> findAll() {
		return reservationService.findAll();
	}
}
