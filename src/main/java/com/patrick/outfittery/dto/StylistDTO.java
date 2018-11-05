package com.patrick.outfittery.dto;

import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.model.StylistStatusEnum;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Patrick B.
 * 11/4/18
 */
@Data
public class StylistDTO {

	private Long id;
	private String name;
	private StylistStatusEnum status;
	private Set<TimeSlotDTO> timeSlots;

	public StylistDTO() {
	}

	public StylistDTO(StylistEntity entity) {
		this.setId(entity.getId());
		this.setName(entity.getName());
		this.setStatus(entity.getStatus());
		this.setTimeSlots(entity.getTimeSlots()
				.stream().map(TimeSlotDTO::new).collect(Collectors.toSet()));
	}
}
