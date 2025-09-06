package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
