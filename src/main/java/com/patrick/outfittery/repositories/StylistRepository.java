package com.patrick.outfittery.repositories;

import com.patrick.outfittery.entities.StylistEntity;
import com.patrick.outfittery.model.StylistStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Repository
public interface StylistRepository extends JpaRepository<StylistEntity, Long> {
	List<StylistEntity> findByStatus(StylistStatusEnum ready);
}
