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
    private double prix;
    //private String emplacement;
    private String type_service;
    private Long agentId;   // référence à l’agent qui propose
    private Long siteId;    // référence au site associé
}
