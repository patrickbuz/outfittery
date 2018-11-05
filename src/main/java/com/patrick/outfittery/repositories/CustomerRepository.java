package com.patrick.outfittery.repositories;

import com.patrick.outfittery.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Patrick B.
 * 11/4/18
 */

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
