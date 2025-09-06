package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
