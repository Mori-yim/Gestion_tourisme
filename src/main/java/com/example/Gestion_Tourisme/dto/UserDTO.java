package com.example.Gestion_Tourisme.dto;

import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.entity.Service;
import com.example.Gestion_Tourisme.entity.SiteTouristique;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String nom;
    private String prenom;
    private String email;
   // private String motDePass;
    private String telephone;
    private Date dateInscription;
    private List<Long> id_siteTouristiques = new ArrayList<>();
    private List<Long> id_services = new ArrayList<>();
    private List<Long> id_reservations = new ArrayList<>();

}
