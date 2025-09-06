package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
