package com.example.Gestion_Tourisme.dto.reservationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {
    private Long id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String statut;
    private Long clientId;
    private Long serviceId;
    private Long siteId;

}
