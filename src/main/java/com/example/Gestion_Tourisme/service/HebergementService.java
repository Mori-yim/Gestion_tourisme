package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementRequestDTO;
import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementResponseDTO;

import java.util.List;

public interface HebergementService {
    public HebergementResponseDTO create(HebergementRequestDTO hebergementRequestDTO);
    public HebergementResponseDTO  getById(Long id);
    public List<HebergementResponseDTO> getAll();
    public HebergementResponseDTO updateById(Long id, HebergementRequestDTO hebergementRequestDTO);
    public void delete(Long id);
}
