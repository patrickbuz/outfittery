package com.patrick.outfittery.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

@Entity(name = "customer")
@Getter
@Setter
@EqualsAndHashCode(exclude = "reservations")
public class CustomerEntity {

	public CustomerEntity() {
	}

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	@NotNull
	private String emailAddress;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReservationEntity> reservations = new HashSet<>();
}
