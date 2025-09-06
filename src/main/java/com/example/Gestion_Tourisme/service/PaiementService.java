package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.paiementDto.PaiementRequestDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementResponseDTO;
import com.example.Gestion_Tourisme.entity.Paiement;

import java.util.List;

public interface PaiementService {
    public PaiementResponseDTO create(PaiementRequestDTO paiementRequestDTO);
    public PaiementResponseDTO getById(Long id);
    public List<PaiementResponseDTO>  getAll();
    public PaiementResponseDTO updateById(Long id, PaiementRequestDTO paiementRequestDTO);
    public void delete(Long id);
}