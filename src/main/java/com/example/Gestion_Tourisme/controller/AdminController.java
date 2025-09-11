package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<AdminResponseDTO> create(@Valid @RequestBody AdminRequestDTO adminRequestDTO){
        return new ResponseEntity<>(adminService.create(adminRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<AdminResponseDTO> getAll(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdminResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(adminService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AdminResponseDTO> update(@PathVariable Long id, @RequestBody AdminRequestDTO adminRequestDTO){
        return new ResponseEntity<>(adminService.UpdateById(id,adminRequestDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }
     // 🔹 Dashboard / Statistiques
    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardStats() {
        return adminService.getDashboardStats();
    }

}
