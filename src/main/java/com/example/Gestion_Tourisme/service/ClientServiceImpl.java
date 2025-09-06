package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.clientDto.ClientRequestDto;
import com.example.Gestion_Tourisme.dto.clientDto.ClientResponseDto;
import com.example.Gestion_Tourisme.entity.Admin;
import com.example.Gestion_Tourisme.entity.Client;
import com.example.Gestion_Tourisme.repository.AdminRepository;
import com.example.Gestion_Tourisme.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientResponseDto create(ClientRequestDto clientRequestDto) {
        Client client = modelMapper.map(clientRequestDto,Client.class);
        Client saveClient= clientRepository.save(client);
        return modelMapper.map(saveClient,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto getById(Long id) {
        Client client = clientRepository.findById(id).get();
        return modelMapper.map(client,ClientResponseDto.class);
    }

    @Override
    public List<ClientResponseDto> getAll() {
        //List<Client> clients = clientRepository.findAll();
        return clientRepository.findAll().stream()
                .map(user -> modelMapper.map(user, ClientResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDto UpdateById(Long id, ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto= getById(id);
        Client existClient = modelMapper.map(clientResponseDto,Client.class);
        existClient.setName(clientRequestDto.getName());
        existClient.setUsername(clientRequestDto.getUsername());
        existClient.setEmail(clientRequestDto.getEmail());
        existClient.setPassword(clientRequestDto.getPassword());
        existClient.setTelephone(clientRequestDto.getTelephone());
        Client saveClient = clientRepository.save(existClient);
        return modelMapper.map(saveClient,ClientResponseDto.class);
    }
}
