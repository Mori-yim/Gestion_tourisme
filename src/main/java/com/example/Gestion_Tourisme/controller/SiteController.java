package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueRequestDTO;
import com.example.Gestion_Tourisme.dto.siteTouristiqueDto.SiteTouristiqueResponseDTO;
import com.example.Gestion_Tourisme.entity.SiteTouristique;
import com.example.Gestion_Tourisme.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")
public class SiteController {
    @Autowired
    private SiteService siteService;

    @PostMapping("/create")
    public ResponseEntity<SiteTouristiqueResponseDTO> create(@RequestBody SiteTouristiqueRequestDTO site){
        return new ResponseEntity<>(siteService.create(site), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<SiteTouristiqueResponseDTO> getAll(){
        return siteService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SiteTouristiqueResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(siteService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SiteTouristiqueResponseDTO> update(@PathVariable Long id, @RequestBody SiteTouristiqueRequestDTO site){
        return new ResponseEntity<>(siteService.UpdateById(id,site),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        siteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // 🔹 Recherche site par nom
    @GetMapping("/sites/nom/{nom}")
    public /*List<SiteTouristiqueResponseDTO>*/ResponseEntity<SiteTouristiqueResponseDTO> searchSitesByNom(@PathVariable String nom) {
        return new ResponseEntity<>(siteService.chearchByNom(nom),HttpStatus.OK);
    }
    // 🔹 Recherche site par localisation
    @GetMapping("/sites/localisation/{localisation}")
    public List<SiteTouristique> searchSitesByLocalisation(@PathVariable String localisation) {
        return siteService.chearchByLocalisation(localisation);
    }
}
