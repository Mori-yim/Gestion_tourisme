package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.entity.Reservation;

import java.util.List;

public interface ReservationService {
    public ReservationResponseDTO create(ReservationRequestDTO reservationRequestDTO);
    public ReservationResponseDTO getById(Long id);
    public List<ReservationResponseDTO> getAll();
    public ReservationResponseDTO updateById(Long id, ReservationRequestDTO reservationRequestDTO);
    public void delete(Long id);
    public void assignerPaiementService(Long id_reservation,Long id_paiement);
    public List<ReservationResponseDTO> getReservationsByClient(Long clientId);
    public List<ReservationResponseDTO> getHistoriqueReservations(Long clientId);
    public List<ReservationResponseDTO> getReservationsForAgent(Long agentId);
    public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO);
}
