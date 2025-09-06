package com.example.Gestion_Tourisme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteTouristiqueDTO {
    private Long id;
    private String nom;
    private String description;
    private String region;
    private String image;
    private List<Long> id_user= new ArrayList<>();
}
