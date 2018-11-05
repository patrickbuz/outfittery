package com.patrick.outfittery.entities;

import com.patrick.outfittery.model.StylistStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Entity(name = "stylist")
@Getter
@Setter
@EqualsAndHashCode(exclude = "timeSlots")
public class StylistEntity {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String emailAddress;
	private String name;
	@Enumerated
	private StylistStatusEnum status;

	@OneToMany(mappedBy = "stylist")
	private Set<TimeSlotEntity> timeSlots = new HashSet<>();
}
