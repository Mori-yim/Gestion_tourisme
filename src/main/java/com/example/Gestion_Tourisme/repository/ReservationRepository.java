package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
