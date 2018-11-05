package com.patrick.outfittery;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Data
public class Reservation {

	private Long customerId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date time;
}
