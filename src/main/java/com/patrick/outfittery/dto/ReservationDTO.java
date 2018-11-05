package com.patrick.outfittery.dto;

import com.patrick.outfittery.entities.ReservationEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Data
public class ReservationDTO {

	private String customerName;
	private String stylistName;
	private Date time;

	public ReservationDTO() {
	}

	public ReservationDTO(ReservationEntity entity) {
		this.customerName = entity.getCustomer().getName();
		this.stylistName = entity.getTimeSlotEntity().getStylist().getName();
		this.time = entity.getTimeSlotEntity().getTime();
	}
}
