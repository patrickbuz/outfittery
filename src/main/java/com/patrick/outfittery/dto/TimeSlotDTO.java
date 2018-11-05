package com.patrick.outfittery.dto;

import com.patrick.outfittery.entities.TimeSlotEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Data
public class TimeSlotDTO {

	private Long id;
	private Date time;
	private String stylistName;
	private boolean busy;
	private Integer version;

	public TimeSlotDTO(TimeSlotEntity entity) {
		this.id = entity.getId();
		this.time = entity.getTime();
		this.stylistName = entity.getStylist().getName();
		this.busy = entity.isBusy();
		this.version = entity.getVersion();
	}
}
