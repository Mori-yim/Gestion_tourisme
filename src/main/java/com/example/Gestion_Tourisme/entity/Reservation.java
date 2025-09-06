package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;

    @ManyToMany(mappedBy = "reservations", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();


   @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();

}
