package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.entity.Paiement;
import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.repository.PaiementRepository;
import com.example.Gestion_Tourisme.repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private PaiementRepository paiementRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ReservationResponseDTO create(ReservationRequestDTO reservation) {
        Reservation reservation1 = modelMapper.map(reservation, Reservation.class);
        Reservation saveReservation = reservationRepository.save(reservation1);
        return modelMapper.map(saveReservation,ReservationResponseDTO.class);
    }

    @Override
    public ReservationResponseDTO getById(Long id) {
        Reservation reservation= reservationRepository.findById(id).get();
        return modelMapper.map(reservation,ReservationResponseDTO.class);
    }

    @Override
    public List<ReservationResponseDTO> getAll() {
        //List<Reservation> reservations= reservationRepository.findAll();
        return reservationRepository.findAll().stream()
                .map(reservation -> modelMapper.map(reservation, ReservationResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO reservation= getById(id);
        Reservation reservation1 =modelMapper.map(reservation, Reservation.class);
        reservation1.setNom(reservationRequestDTO.getNom());
        reservation1.setDateDebut(reservationRequestDTO.getDateDebut());
        reservation1.setDateFin(reservationRequestDTO.getDateFin());
        Reservation updateReservation = reservationRepository.save(reservation1);

        return modelMapper.map(updateReservation,ReservationResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public void assignerPaiementService(Long id_reservation, Long id_paiement) {
        Reservation reservation = reservationRepository.findById(id_reservation).get();
        Paiement paiement = paiementRepository.findById(id_paiement).get();
        if(paiement.getReservation()!=null){
            //si le paiement est deja assignee a une reservation, alors on leve une exception
            throw new RuntimeException("Le paiement a deja une reservation");
        }
        reservation.getPaiements().add(paiement);
        paiement.setReservation(reservation);
        reservationRepository.save(reservation);
    }
}
