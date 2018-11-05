package com.patrick.outfittery.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Entity
@Data
public class ReservationEntity implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@OneToOne
	@JoinColumn(name = "time_slot_id")
	private TimeSlotEntity timeSlotEntity;
}
