package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String password;
    private String telephone;
    private Date dateInscription;
    private Role role;

    @ManyToMany/*(mappedBy = "siteTouristiques")*/
    @JoinTable(name = "User_site")
    private List<SiteTouristique> siteTouristiques = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "User_Reservation")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_service")
    private List<Service> services= new ArrayList<>();



}