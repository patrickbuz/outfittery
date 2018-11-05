package com.patrick.outfittery;

import com.patrick.outfittery.exceptions.UnavailableSlotException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@ControllerAdvice
public class UnavailableTimeSlotAdvice {

	@ResponseBody
	@ExceptionHandler(UnavailableSlotException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String unavailableSlotHandler(UnavailableSlotException ex) {
		return ex.getMessage();
	}
}
