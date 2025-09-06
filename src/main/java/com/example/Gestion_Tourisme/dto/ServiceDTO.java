package com.example.Gestion_Tourisme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Long id;
    private String nom;
    private String description;
    private float prix;
    private String emplacement;
    private Long id_user;
}
