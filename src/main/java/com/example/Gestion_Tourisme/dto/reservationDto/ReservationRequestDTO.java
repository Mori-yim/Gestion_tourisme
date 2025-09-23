package com.example.Gestion_Tourisme.dto.reservationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
   // private Long id;
    private String nom;
    private LocalDateTime dateReservation=LocalDateTime.now();
    private Date dateDebut;
    private Date dateFin;
    private String statut;
    private Long clientId;
    private Long serviceId;
    private Long siteId;

}
