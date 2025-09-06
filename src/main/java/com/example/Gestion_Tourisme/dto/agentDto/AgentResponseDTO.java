package com.example.Gestion_Tourisme.dto.agentDto;

import com.example.Gestion_Tourisme.dto.UserDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AgentResponseDTO extends UserResponseDTO {
    private String role;
}
