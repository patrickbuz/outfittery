package com.patrick.outfittery.repositories;

import com.patrick.outfittery.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Patrick B.
 * 11/5/18
 */

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
