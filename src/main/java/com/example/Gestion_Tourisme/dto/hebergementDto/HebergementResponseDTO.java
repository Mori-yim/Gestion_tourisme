package com.example.Gestion_Tourisme.dto.hebergementDto;

import com.example.Gestion_Tourisme.dto.ServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class HebergementResponseDTO extends ServiceDTO {
    private String typeHebergement;
    private int nombreChambre;
}
