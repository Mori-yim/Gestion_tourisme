package com.example.Gestion_Tourisme.service;
import com.example.Gestion_Tourisme.entity.Agent;
import com.example.Gestion_Tourisme.repository.AgentRepository;
import com.example.Gestion_Tourisme.repository.ServiceRepository;
import com.example.Gestion_Tourisme.utils.PdfGenerator;

import com.example.Gestion_Tourisme.dto.paiementDto.PaiementRequestDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementResponseDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.repository.PaiementRepository;
import com.example.Gestion_Tourisme.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
    public class PaiementServiceImpl implements PaiementService{
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ModelMapper modelMapper;
//    @Override
//    public PaiementResponseDTO create(PaiementRequestDTO paiement) {
//        Paiement paiement1 = modelMapper.map(paiement, Paiement.class);
//        Paiement savePaiement = paiementRepository.save(paiement1);
//        return modelMapper.map(savePaiement,PaiementResponseDTO.class);
//    }

    // 2️ Paiement + Facture ------------------------
    @Override
    @Transactional
    public ByteArrayInputStream effectuerPaiement(PaiementRequestDTO paiementRequest) {
        Reservation reservation = reservationRepository.findById(paiementRequest.getReservationId())
                .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        Paiement paiement = new Paiement();
        paiement.setReservation(reservation);
        paiement.setMontant(paiementRequest.getMontant());
        paiement.setStatut("SUCCES");

        paiementRepository.save(paiement);

        // Générer une facture PDF avec iText
        //return PdfGenerator.generateFacture(reservation, paiement);
        return null;
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

    // Paiements reçus ------------------------

    public List<PaiementResponseDTO> getPaiementsForAgent(Long agentId) {
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent introuvable"));

        return serviceRepository.findByAgent(agent).stream()
                .flatMap(service -> reservationRepository.findByService(service).stream())
                .flatMap(reservation -> paiementRepository.findByReservation(reservation).stream())
                .map(p -> modelMapper.map(p, PaiementResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        paiementRepository.deleteById(id);

    }
}
