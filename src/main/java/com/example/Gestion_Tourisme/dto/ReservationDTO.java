package com.example.Gestion_Tourisme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private List<Long> id_user;
    private List<Long> id_paiement;
    private Long id_service;
}
