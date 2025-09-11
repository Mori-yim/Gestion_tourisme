package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Client;
import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    // Trouver les réservations d’un client
    List<Reservation> findByClient(Client client);

    // Trouver les réservations d’un service
    List<Reservation> findByService(Service service);
}
