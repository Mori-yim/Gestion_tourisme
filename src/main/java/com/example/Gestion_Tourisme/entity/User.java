package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String telephone;
    private LocalDateTime dateInscription = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Role role;

//    @ManyToMany/*(mappedBy = "siteTouristiques")*/
//    @JoinTable(name = "User_site")
//    private List<SiteTouristique> siteTouristiques = new ArrayList<>();
//
//    @ManyToMany
//    @JoinTable(name = "User_Reservation")
//    private List<Reservation> reservations = new ArrayList<>();
//
//    @ManyToMany
//    @JoinTable(name = "user_service")
//    private List<Service> services= new ArrayList<>();
    /*
    Client → Reservations → Paiements
    Agent → Services → Reservations
    Admin → CRUD Sites + Services
    SiteTouristic → Services
     */



}