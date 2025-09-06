package com.example.Gestion_Tourisme.dto.siteTouristiqueDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteTouristiqueResponseDTO {
    private Long id;
    private String nom;
    private String description;
    private String localisation;
    private String image;
    private String climat;

}
