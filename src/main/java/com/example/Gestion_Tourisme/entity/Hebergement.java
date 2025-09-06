package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hebergement extends Service{
    private String typeHebergement;
    private int nombreChambre;

}
