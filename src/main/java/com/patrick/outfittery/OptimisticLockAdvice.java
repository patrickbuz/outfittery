package com.patrick.outfittery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.OptimisticLockException;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@ControllerAdvice
public class OptimisticLockAdvice {

	@ResponseBody
	@ExceptionHandler(OptimisticLockException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	String optimisticLockHandler() {
		return "There was a conflict while trying to perform your reservation. Please try again";
	}
}
