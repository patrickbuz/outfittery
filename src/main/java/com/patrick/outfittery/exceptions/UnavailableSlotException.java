package com.patrick.outfittery.exceptions;

import java.util.Date;

/**
 * Created by Patrick B.
 * 11/5/18
 */
public class UnavailableSlotException extends RuntimeException {

	public UnavailableSlotException(Date time) {
		super("Unavailable slot for time: " + time);
	}
}
