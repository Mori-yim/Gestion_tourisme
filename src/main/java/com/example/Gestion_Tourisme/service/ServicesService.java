package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.entity.User;

import java.util.List;

public interface ServicesService {
    //public ServiceResponseDTO create(ServiceRequestDTO serviceRequestDTO);
    public ServiceResponseDTO createService(ServiceRequestDTO serviceRequest);
    public ServiceResponseDTO getById(Long id);
    public List<ServiceResponseDTO> getAll();
    public ServiceResponseDTO updateById(Long id, ServiceRequestDTO serviceRequestDTO);
    public void delete(Long id);
    public List<ServiceResponseDTO> getServicesByAgent(Long agentId);


}
