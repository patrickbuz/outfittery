package com.patrick.outfittery.exceptions;

/**
 * Created by Patrick B.
 * 11/4/18
 */
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(Long id) {
		super("Could not find resource with id: " + id);
	}
}
