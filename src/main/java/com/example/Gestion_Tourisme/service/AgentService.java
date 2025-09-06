package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.agentDto.AgentRequestDTO;
import com.example.Gestion_Tourisme.dto.agentDto.AgentResponseDTO;
import com.example.Gestion_Tourisme.dto.clientDto.ClientRequestDto;
import com.example.Gestion_Tourisme.dto.clientDto.ClientResponseDto;

import java.util.List;

public interface  AgentService {
    public AgentResponseDTO create(AgentRequestDTO agentRequestDTO);
    public AgentResponseDTO getById(Long id);
    public List<AgentResponseDTO> getAll();
    public AgentResponseDTO UpdateById(Long id, AgentRequestDTO agentRequestDTO);
}
