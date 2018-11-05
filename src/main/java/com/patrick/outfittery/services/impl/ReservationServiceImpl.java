package com.patrick.outfittery.services.impl;

import com.patrick.outfittery.exceptions.UnavailableSlotException;
import com.patrick.outfittery.repositories.ReservationRepository;
import com.patrick.outfittery.repositories.TimeSlotRepository;
import com.patrick.outfittery.services.ReservationService;
import com.patrick.outfittery.Reservation;
import com.patrick.outfittery.dto.ReservationDTO;
import com.patrick.outfittery.entities.CustomerEntity;
import com.patrick.outfittery.entities.ReservationEntity;
import com.patrick.outfittery.entities.TimeSlotEntity;
import com.patrick.outfittery.exceptions.ResourceNotFoundException;
import com.patrick.outfittery.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@Service
public class ReservationServiceImpl implements ReservationService {

	private final ReservationRepository reservationRepository;
	private final CustomerRepository customerRepository;
	private final TimeSlotRepository timeSlotRepository;

	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository, CustomerRepository customerRepository, TimeSlotRepository timeSlotRepository) {
		this.reservationRepository = reservationRepository;
		this.customerRepository = customerRepository;
		this.timeSlotRepository = timeSlotRepository;
	}

	@Transactional
	@Override
	public ReservationDTO save(Reservation reservation) {
		CustomerEntity customer = customerRepository.findById(reservation.getCustomerId())
				.orElseThrow(() -> new ResourceNotFoundException(reservation.getCustomerId()));
		TimeSlotEntity timeSlot = timeSlotRepository.findFirstByTimeAndBusy(reservation.getTime(), false)
				.orElseThrow(() -> new UnavailableSlotException(reservation.getTime()));
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCustomer(customer);
		reservationEntity.setTimeSlotEntity(timeSlot);
		timeSlot.setBusy(true);
		timeSlotRepository.save(timeSlot);
		return new ReservationDTO(reservationRepository.save(reservationEntity));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReservationDTO> findAll() {
		return reservationRepository.findAll().stream().map(ReservationDTO::new).collect(Collectors.toList());
	}
}
