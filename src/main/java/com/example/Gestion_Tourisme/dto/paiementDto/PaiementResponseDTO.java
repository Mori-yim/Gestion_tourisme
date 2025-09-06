package com.example.Gestion_Tourisme.dto.paiementDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
  PaiementResponseDTO {
    private Long id;
    private float montant;
    private Date datePaiement;
    private String methodePaiement;
    private String statut;
}
