package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementRequestDTO;
import com.example.Gestion_Tourisme.dto.paiementDto.PaiementResponseDTO;
import com.example.Gestion_Tourisme.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/create")
    public ResponseEntity<PaiementResponseDTO> create(@RequestBody PaiementRequestDTO paiementRequestDTO){
        return new ResponseEntity<>(paiementService.create(paiementRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<PaiementResponseDTO> getAll(){
        return paiementService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaiementResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(paiementService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PaiementResponseDTO> update(@PathVariable Long id, @RequestBody PaiementRequestDTO paiementRequestDTO){
        return new ResponseEntity<>(paiementService.updateById(id,paiementRequestDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        paiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
