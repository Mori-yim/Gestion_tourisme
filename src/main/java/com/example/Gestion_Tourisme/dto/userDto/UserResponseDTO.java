package com.example.Gestion_Tourisme.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;

    private String name;
    private String username;
    private String email;
    private String telephone;
    private LocalDateTime dateInscription;
    private Role role;

}
