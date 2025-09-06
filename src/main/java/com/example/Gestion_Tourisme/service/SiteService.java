package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueRequestDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueResponseDTO;

import java.util.List;

public interface SiteService {
    public SiteTouristiqueResponseDTO create(SiteTouristiqueRequestDTO siteTouristiqueRequestDTO);
    public SiteTouristiqueResponseDTO getById(Long id);
    public List<SiteTouristiqueResponseDTO> getAll();
    public SiteTouristiqueResponseDTO UpdateById(Long id, SiteTouristiqueRequestDTO siteTouristiqueRequestDTO);
    public void delete(Long id);
}
