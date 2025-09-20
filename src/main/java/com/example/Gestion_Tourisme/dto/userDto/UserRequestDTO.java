package com.example.Gestion_Tourisme.dto.userDto;

import com.example.Gestion_Tourisme.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UserRequestDTO {
    //private Long id;
   // @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    //@Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et 50 caractères")
    private String name;
    private String username;
    private String email;
    private String password;
    private String telephone;
    private LocalDateTime dateInscription = LocalDateTime.now();
    private Role role;


}
