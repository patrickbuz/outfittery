package com.patrick.outfittery.controllers;

import com.patrick.outfittery.dto.TimeSlotDTO;
import com.patrick.outfittery.services.TimeSlotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@RestController
public class TimeSlotController {

	private final TimeSlotService timeSlotService;

	public TimeSlotController(TimeSlotService timeSlotService) {
		this.timeSlotService = timeSlotService;
	}

	@PostMapping("/timeSlot")
	public List<TimeSlotDTO> initNextDay() {
		return timeSlotService.initNextDay();
	}

	@GetMapping("/timeSlot")
	public Set<Date> findAllAvailable() {
		return timeSlotService.findAllAvailable();
	}
}
