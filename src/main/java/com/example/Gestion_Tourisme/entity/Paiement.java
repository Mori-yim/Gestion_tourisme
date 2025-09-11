package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    private double montant;
    private String methodePaiement; // ex: "CARD", "CASH", "MOBILE_MONEY"
    private String statut; // ex: "PAID", "PENDING"
    private LocalDateTime datePaiement;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_reservation")
    //private Reservation reservation;

}
