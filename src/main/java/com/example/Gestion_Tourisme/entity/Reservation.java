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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String statut; // EN_ATTENTE, CONFIRMEE, ANNULEE
    private LocalDateTime dateReservation = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements = new ArrayList<>();

   // @ManyToMany(mappedBy = "reservations", fetch = FetchType.EAGER)
    //private List<User> users = new ArrayList<>();


   //@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    //private List<Paiement> paiements = new ArrayList<>();

}
