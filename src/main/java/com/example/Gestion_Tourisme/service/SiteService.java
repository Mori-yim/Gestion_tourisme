package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueRequestDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueResponseDTO;
import com.example.Gestion_Tourisme.entity.SiteTouristique;

import java.util.List;

public interface SiteService {
    public SiteTouristiqueResponseDTO create(SiteTouristiqueRequestDTO siteTouristiqueRequestDTO);
    public SiteTouristiqueResponseDTO getById(Long id);
    public List<SiteTouristiqueResponseDTO> getAll();
    public SiteTouristiqueResponseDTO UpdateById(Long id, SiteTouristiqueRequestDTO siteTouristiqueRequestDTO);
    public void delete(Long id);
    public List<SiteTouristiqueResponseDTO> searchSites(SiteTouristiqueRequestDTO siteRequest);
    public SiteTouristiqueResponseDTO chearchByNom(String nom);
    public List<SiteTouristique> chearchByLocalisation(String localisation);
}
