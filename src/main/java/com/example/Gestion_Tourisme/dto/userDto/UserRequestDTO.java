package com.example.Gestion_Tourisme.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    //private Long id;
   // @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    //@Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
    private String name;
    private String username;
   // @NotBlank(message = "L'email est obligatoire")
    //@Email(message = "Email invalide")
    private String email;
    //@NotBlank(message = "Le mot de passe est obligatoire")
    //@Size(min = 6, max = 120, message = "Le mot de passe doit contenir entre 6 et 120 caractères")
    private String password;
    private String telephone;
    private Date dateInscription;


}
