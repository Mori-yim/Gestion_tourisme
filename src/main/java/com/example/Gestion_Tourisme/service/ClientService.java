package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.clientDto.ClientRequestDto;
import com.example.Gestion_Tourisme.dto.clientDto.ClientResponseDto;

import java.util.List;

public interface ClientService {
    public ClientResponseDto create(ClientRequestDto clientRequestDto);
    public ClientResponseDto getById(Long id);
    public List<ClientResponseDto> getAll();
    public ClientResponseDto UpdateById(Long id, ClientRequestDto clientRequestDto);
}
