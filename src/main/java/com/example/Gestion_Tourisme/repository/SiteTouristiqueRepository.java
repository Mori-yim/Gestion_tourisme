package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.SiteTouristique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteTouristiqueRepository extends JpaRepository<SiteTouristique,Long> {
    // Recherche par nom (contient une partie du texte)
    SiteTouristique findByNomContainingIgnoreCase(String nom);

    // Recherche par localisation
    List<SiteTouristique> findByLocalisationContainingIgnoreCase(String localisation);
}
