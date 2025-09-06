package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.agentDto.AgentRequestDTO;
import com.example.Gestion_Tourisme.dto.agentDto.AgentResponseDTO;
import com.example.Gestion_Tourisme.entity.Admin;
import com.example.Gestion_Tourisme.entity.Agent;
import com.example.Gestion_Tourisme.repository.AdminRepository;
import com.example.Gestion_Tourisme.repository.AgentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class  AgentServiceImpl implements AgentService{
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AgentResponseDTO create(AgentRequestDTO agentRequestDTO) {
        Agent agent = modelMapper.map(agentRequestDTO,Agent.class);
        Agent saveAgent= agentRepository.save(agent);
        return modelMapper.map(saveAgent,AgentResponseDTO.class);
    }

    @Override
    public AgentResponseDTO getById(Long id) {
        Agent agent = agentRepository.findById(id).get();
        return modelMapper.map(agent,AgentResponseDTO.class);
    }

    @Override
    public List<AgentResponseDTO> getAll() {
       //List<Agent> agents= agentRepository.findAll();
        return agentRepository.findAll().stream()
                .map(agent -> modelMapper.map(agent, AgentResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AgentResponseDTO UpdateById(Long id, AgentRequestDTO agentRequestDTO) {
        AgentResponseDTO agentResponseDTO = getById(id);
        Agent existAgent= modelMapper.map(agentResponseDTO,Agent.class);
        existAgent.setName(agentRequestDTO.getName());
        existAgent.setUsername(agentRequestDTO.getUsername());
        existAgent.setEmail(agentRequestDTO.getEmail());
        existAgent.setPassword(agentRequestDTO.getPassword());
        existAgent.setTelephone(agentRequestDTO.getTelephone());
        Agent saveAgent = agentRepository.save(existAgent);
        return modelMapper.map(saveAgent,AgentResponseDTO.class);
    }

}
