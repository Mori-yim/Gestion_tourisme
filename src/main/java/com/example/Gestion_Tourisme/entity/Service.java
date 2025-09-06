package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class  Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private float prix;
    private String emplacement;
    private String type_service;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY)
    private List<User> users= new ArrayList<>();

}
