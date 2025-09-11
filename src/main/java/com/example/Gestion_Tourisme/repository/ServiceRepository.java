package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.Agent;
import com.example.Gestion_Tourisme.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    // Trouver les services par agent
    List<Service> findByAgent(Agent agent);

    // Trouver les services par site
    List<Service> findBySiteId(Long siteId);
}
