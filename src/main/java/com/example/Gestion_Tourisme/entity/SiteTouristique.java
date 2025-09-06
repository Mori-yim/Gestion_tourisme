package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class SiteTouristique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String localisation;
    private String image;
    private String climat;


    @ManyToMany(mappedBy = "siteTouristiques", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();


}
