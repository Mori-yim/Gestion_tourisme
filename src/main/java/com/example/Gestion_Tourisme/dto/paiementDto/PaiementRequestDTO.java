package com.example.Gestion_Tourisme.dto.paiementDto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementRequestDTO {
    //private Long id;
    @Positive(message = "Le montant doit etre positif b")
    private double montant;
    private String methodePaiement;
    private String statut;
    private LocalDateTime datePaiement=LocalDateTime.now();
    private Long reservationId;
}
