package com.example.Gestion_Tourisme.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Admin extends User{
    private String code;
}
