package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{
    private String code; // exemple : code interne pour l’admin

}
