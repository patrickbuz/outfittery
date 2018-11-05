package com.patrick.outfittery.repositories;

import com.patrick.outfittery.entities.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, Long> {

	Optional<TimeSlotEntity> findFirstByTimeAndBusy(Date time, boolean busy);

	Set<TimeSlotEntity> findAllByBusy(boolean busy);
}
