package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementRequestDTO;
import com.example.Gestion_Tourisme.dto.hebergementDto.HebergementResponseDTO;
import com.example.Gestion_Tourisme.service.HebergementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hebergement")
public class HebergementController {
    @Autowired
    private HebergementService hebergementService;

    @PostMapping("/create")
    public ResponseEntity<HebergementResponseDTO> create(@RequestBody HebergementRequestDTO hebergementRequestDTO){
        return new ResponseEntity<>(hebergementService.create(hebergementRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<HebergementResponseDTO> getAll(){
        return hebergementService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<HebergementResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(hebergementService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HebergementResponseDTO> update(@PathVariable Long id, @RequestBody HebergementRequestDTO hebergementRequestDTO){
        return new ResponseEntity<>(hebergementService.updateById(id,hebergementRequestDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hebergementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
