package com.example.Gestion_Tourisme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class HebergementDTO extends ServiceDTO {
    private String typeHebergement;
    private int nombreChambre;
}
