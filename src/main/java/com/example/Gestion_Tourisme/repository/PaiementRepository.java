package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
    // Trouver les paiements liés à une réservation
    List<Paiement> findByReservation(Reservation reservation);

    // Trouver les paiements selon leur statut
    List<Paiement> findByStatut(String statut);
}
