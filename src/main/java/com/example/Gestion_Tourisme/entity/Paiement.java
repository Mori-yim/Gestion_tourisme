package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float montant;
    private Date datePaiement;
    private String methodePaiement;
    private String statut;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

}
