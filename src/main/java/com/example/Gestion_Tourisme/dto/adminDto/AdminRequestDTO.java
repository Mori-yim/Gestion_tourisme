package com.example.Gestion_Tourisme.dto.adminDto;

import com.example.Gestion_Tourisme.dto.UserDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDTO extends UserRequestDTO {
    private String code;

}
