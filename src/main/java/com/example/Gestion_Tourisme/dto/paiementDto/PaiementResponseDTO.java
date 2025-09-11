package com.example.Gestion_Tourisme.dto.paiementDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
  PaiementResponseDTO {
    private Long id;
    private double montant;
    private LocalDateTime datePaiement;
    private String methodePaiement;
    private String statut;
}
