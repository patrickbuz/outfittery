package com.patrick.outfittery.dto;

import com.patrick.outfittery.entities.CustomerEntity;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Data
public class CustomerDTO {

	private Long id;
	private String name;
	private Set<ReservationDTO> reservations;

	public CustomerDTO() {
	}

	public CustomerDTO(CustomerEntity entity) {
		this.setId(entity.getId());
		this.setName(entity.getName());
		this.setReservations(entity.getReservations()
				.stream().map(ReservationDTO::new).collect(Collectors.toSet()));
	}
}
