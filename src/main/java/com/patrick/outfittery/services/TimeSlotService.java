package com.patrick.outfittery.services;

import com.patrick.outfittery.dto.TimeSlotDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Service
public interface TimeSlotService {

	List<TimeSlotDTO> initNextDay();

	Set<Date> findAllAvailable();
}
