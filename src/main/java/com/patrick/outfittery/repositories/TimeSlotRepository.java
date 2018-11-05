package com.patrick.outfittery.repositories;

import com.patrick.outfittery.entities.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Patrick B.
 * 11/4/18
 */
public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Long> {

	Optional<TimeSlotEntity> findFirstByTimeAndBusy(Date time, boolean busy);
}
