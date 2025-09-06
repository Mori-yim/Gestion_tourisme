package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.Service;
import com.example.Gestion_Tourisme.entity.User;
import com.example.Gestion_Tourisme.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService{

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ServiceResponseDTO create(ServiceRequestDTO service) {
        Service service1= modelMapper.map(service,Service.class);
        Service saveService = serviceRepository.save(service1);
        return modelMapper.map(saveService,ServiceResponseDTO.class);
    }

    @Override
    public ServiceResponseDTO getById(Long id) {
        Service service= serviceRepository.findById(id).get();
        return modelMapper.map(service,ServiceResponseDTO.class);
    }

    @Override
    public List<ServiceResponseDTO> getAll() {
        //List<Service> services= serviceRepository.findAll();
        return serviceRepository.findAll().stream()
                .map(service -> modelMapper.map(service, ServiceResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceResponseDTO updateById(Long id, ServiceRequestDTO serviceRequestDTO) {
        ServiceResponseDTO service= getById(id);
        Service service1=modelMapper.map(service,Service.class);
        service1.setNom(serviceRequestDTO.getNom());
        service1.setDescription(serviceRequestDTO.getDescription());
        service1.setPrix(serviceRequestDTO.getPrix());
        service1.setEmplacement(serviceRequestDTO.getEmplacement());
        service1.setType_service(serviceRequestDTO.getType_service());
        Service updateService = serviceRepository.save(service1);

        return modelMapper.map(updateService,ServiceResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);

    }

}
