package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.Agent;
import com.example.Gestion_Tourisme.entity.Service;
import com.example.Gestion_Tourisme.entity.SiteTouristique;
import com.example.Gestion_Tourisme.entity.User;
import com.example.Gestion_Tourisme.repository.AgentRepository;
import com.example.Gestion_Tourisme.repository.ServiceRepository;
import com.example.Gestion_Tourisme.repository.SiteTouristiqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService{

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private SiteTouristiqueRepository siteTouristique;

//    public ServiceResponseDTO create(ServiceRequestDTO service) {
//        Service service1= modelMapper.map(service,Service.class);
//        Service saveService = serviceRepository.save(service1);
//        return modelMapper.map(saveService,ServiceResponseDTO.class);
//    }

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
        service1.setPrix( serviceRequestDTO.getPrix());
       // service1.setEmplacement(serviceRequestDTO.getEmplacement());
        service1.setType_service(serviceRequestDTO.getType_service());
        Service updateService = serviceRepository.save(service1);

        return modelMapper.map(updateService,ServiceResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);

    }
    // Ajouter un service touristique  (ex: guide, transport, excursion).
    @Transactional
    public ServiceResponseDTO createService(ServiceRequestDTO serviceRequest) {
//        Agent agent = agentRepository.findById(serviceRequest.getAgentId())
//                .orElseThrow(() -> new RuntimeException("Agent introuvable"));
//
//        Service service = modelMapper.map(serviceRequest,Service.class);
//        service.setAgent(agent);
//
//        Service saved = serviceRepository.save(service);
//        return modelMapper.map(saved, ServiceResponseDTO.class);
        // Création d'une nouvelle entité Service
        Service service = new Service();
        service.setNom(serviceRequest.getNom());
        service.setDescription(serviceRequest.getDescription());
        service.setPrix(serviceRequest.getPrix());
        service.setType_service(serviceRequest.getType_service());

        // Récupérer l'Agent par son id
        Agent agent = agentRepository.findById(serviceRequest.getAgentId())
                .orElseThrow(() -> new RuntimeException("Agent non trouvé avec id : " + serviceRequest.getAgentId()));
        service.setAgent(agent);

        // Récupérer le Site par son id
        SiteTouristique site = siteTouristique.findById(serviceRequest.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site non trouvé avec id : " + serviceRequest.getSiteId()));
        service.setSite(site);

        // Pas besoin de setter l'id → généré automatiquement par la DB
         Service service1=serviceRepository.save(service);
         return modelMapper.map(service1,ServiceResponseDTO.class);
    }

    // Lire les services d’un agent
    public List<ServiceResponseDTO> getServicesByAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent introuvable"));

        return serviceRepository.findByAgent(agent)
                .stream()
                .map(s -> modelMapper.map(s, ServiceResponseDTO.class))
                .collect(Collectors.toList());
    }

}
