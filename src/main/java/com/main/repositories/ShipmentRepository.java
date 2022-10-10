package com.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.models.Shipments;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipments, Long> {

	public boolean existByMail();
}
