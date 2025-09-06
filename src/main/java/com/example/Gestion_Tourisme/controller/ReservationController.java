package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationRequestDTO;
import com.example.Gestion_Tourisme.dto.reservationDto.ReservationResponseDTO;
import com.example.Gestion_Tourisme.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public ResponseEntity<ReservationResponseDTO> create(@RequestBody ReservationRequestDTO reservationRequestDTO){
        return new ResponseEntity<>(reservationService.create(reservationRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<ReservationResponseDTO> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(reservationService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationResponseDTO> update(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO){
        return new ResponseEntity<>(reservationService.updateById(id,reservationRequestDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
