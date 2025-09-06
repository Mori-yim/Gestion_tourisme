package com.example.Gestion_Tourisme.dto.paiementDto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaiementRequestDTO {
    //private Long id;
    @Positive(message = "Le montant doit etre positif b")
    private float montant;
    private Date datePaiement;
    private String methodePaiement;
    private String statut;
}
