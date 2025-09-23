package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.service.ClientService;
import com.example.Gestion_Tourisme.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;

    @PostMapping("/client/reservation/create")
    public ResponseEntity<ReservationResponseDTO> create(@RequestBody ReservationRequestDTO reservationRequestDTO){
        return new ResponseEntity<>(reservationService.createReservation(reservationRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/reservation/")
    public List<ReservationResponseDTO> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(reservationService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/reservation/update/{id}")
    public ResponseEntity<ReservationResponseDTO> update(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO){
        return new ResponseEntity<>(reservationService.updateById(id,reservationRequestDTO),HttpStatus.OK);
    }
    @DeleteMapping("/reservation/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // 🔹 Faire une réservation
    @PostMapping("/{clientId}/reservations/{serviceId}")
    public ReservationResponseDTO reserverService(/*@PathVariable Long clientId,
                                          @PathVariable Long serviceId*/ @RequestBody ReservationRequestDTO requestDTO) {
        return reservationService.create(/*clientId, serviceId*/requestDTO);
    }
    // 🔹 Consulter ses réservations
    @GetMapping("/{clientId}/reservations")
    public List<ReservationResponseDTO> getHistoriqueReservations(@PathVariable Long clientId) {
        return reservationService.getHistoriqueReservations(clientId);
    }
    /*public ReservationResponseDTO updateReservation(@PathVariable Long clientId,
                                            @PathVariable Long reservationId,
                                            @RequestBody ReservationResponseDTO dto) {
        return clientService.updateReservation(clientId, reservationId, dto);
    }*/

   // 🔹 Réservations liées à ses services
    @GetMapping("/{agentId}/reservations")
    public List<ReservationResponseDTO> getReservationsByAgent(@PathVariable Long agentId) {
        return reservationService.getReservationsForAgent(agentId);
    }

   
}
