package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.paiementDto.PaiementRequestDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementResponseDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.repository.PaiementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaiementServiceImpl implements PaiementService{
    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PaiementResponseDTO create(PaiementRequestDTO paiement) {
        Paiement paiement1 = modelMapper.map(paiement, Paiement.class);
        Paiement savePaiement = paiementRepository.save(paiement1);
        return modelMapper.map(savePaiement,PaiementResponseDTO.class);
    }

    @Override
    public PaiementResponseDTO getById(Long id) {
        Paiement paiement= paiementRepository.findById(id).get();
        return modelMapper.map(paiement,PaiementResponseDTO.class);
    }

    @Override
    public List<PaiementResponseDTO> getAll() {
        //List<Paiement> paiements= paiementRepository.findAll();
        return paiementRepository.findAll().stream()
                .map(paiement -> modelMapper.map(paiement, PaiementResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PaiementResponseDTO updateById(Long id, PaiementRequestDTO paiementRequestDTO) {
        PaiementResponseDTO paiementResponseDTO= getById(id);
        Paiement paiement =modelMapper.map(paiementResponseDTO, Paiement.class);
        paiement.setMontant(paiementRequestDTO.getMontant());
        paiement.setDatePaiement(paiementRequestDTO.getDatePaiement());
        paiement.setMethodePaiement(paiementRequestDTO.getMethodePaiement());
        paiement.setStatut(paiementRequestDTO.getStatut());
        Paiement updatePaiement = paiementRepository.save(paiement);

        return modelMapper.map(updatePaiement,PaiementResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        paiementRepository.deleteById(id);

    }
}
