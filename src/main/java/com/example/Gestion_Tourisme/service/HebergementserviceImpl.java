package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementRequestDTO;
import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementResponseDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementRequestDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementResponseDTO;
import com.example.Gestion_Tourisme.entity.Hebergement;
import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.repository.HebergementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HebergementserviceImpl implements HebergementService{
    @Autowired
    private HebergementRepository hebergementRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public HebergementResponseDTO create(HebergementRequestDTO hebergement) {
        Hebergement hebergement1 = modelMapper.map(hebergement, Hebergement.class);
        Hebergement saveHebergement = hebergementRepository.save(hebergement1);
        return modelMapper.map(saveHebergement,HebergementResponseDTO.class);
    }

    @Override
    public HebergementResponseDTO getById(Long id) {
        Hebergement hebergement= hebergementRepository.findById(id).get();
        return modelMapper.map(hebergement,HebergementResponseDTO.class);
    }

    @Override
    public List<HebergementResponseDTO> getAll() {
        // List<Hebergement> hebergements = hebergementRepository.findAll();
        return hebergementRepository.findAll().stream()
                .map(hebergement -> modelMapper.map(hebergement, HebergementResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HebergementResponseDTO updateById(Long id, HebergementRequestDTO hebergementRequestDTO) {
        HebergementResponseDTO hebergementResponseDTO= getById(id);
        Hebergement hebergement =modelMapper.map(hebergementResponseDTO, Hebergement.class);
        hebergement.setTypeHebergement(hebergementRequestDTO.getTypeHebergement());
        hebergement.setNombreChambre(hebergementRequestDTO.getNombreChambre());
        Hebergement updateHebergement = hebergementRepository.save(hebergement);

        return modelMapper.map(updateHebergement,HebergementResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        hebergementRepository.deleteById(id);

    }
}
