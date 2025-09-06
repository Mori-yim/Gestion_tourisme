package com.example.Gestion_Tourisme.dto.serviceDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestDTO {
    //private Long id;
    private String nom;
    private String description;
    private float prix;
    private String emplacement;
    private String type_service;
}
