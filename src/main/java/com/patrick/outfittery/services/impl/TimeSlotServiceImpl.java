package com.patrick.outfittery.services.impl;

import com.patrick.outfittery.dto.TimeSlotDTO;
import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.entities.TimeSlotEntity;
import com.patrick.outfittery.model.StylistStatusEnum;
import com.patrick.outfittery.repositories.StylistRepository;
import com.patrick.outfittery.repositories.TimeSlotRepository;
import com.patrick.outfittery.services.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Service
public class TimeSlotServiceImpl implements TimeSlotService {

	private final TimeSlotRepository timeSlotRepository;
	private final StylistRepository stylistRepository;

	@Autowired
	public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, StylistRepository stylistRepository) {
		this.timeSlotRepository = timeSlotRepository;
		this.stylistRepository = stylistRepository;
	}

	@Override
	@Transactional
	public List<TimeSlotDTO> initNextDay() {
		List<StylistEntity> stylists = stylistRepository.findByStatus(StylistStatusEnum.READY);
		Calendar calendar = getNextDayStart();
		int count = 0;
		List<TimeSlotEntity> timeSlots = new ArrayList<>();
		while (count < 16) { // starting from 9am to 4.30pm => 16 time slots
			stylists.forEach(stylist -> {
				TimeSlotEntity timeSlotEntity = new TimeSlotEntity();
				timeSlotEntity.setTime(calendar.getTime());
				timeSlotEntity.setStylist(stylist);
				timeSlots.add(timeSlotEntity);
			});
			calendar.add(Calendar.MINUTE, 30);
			count++;
		}
		return timeSlotRepository.saveAll(timeSlots).stream()
				.map(TimeSlotDTO::new).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<TimeSlotDTO> findAll() {
		return timeSlotRepository.findAll().stream()
				.map(TimeSlotDTO::new).collect(Collectors.toList());
	}

	private Calendar getNextDayStart() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}
}
