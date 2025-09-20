package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceRequestDTO;
import com.example.Gestion_Tourisme.dto.serviceDto.ServiceResponseDTO;
import com.example.Gestion_Tourisme.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceController {
    @Autowired
    private ServicesService service;

    @PostMapping("/agent/service/create")
    public ResponseEntity<ServiceResponseDTO> create(@RequestBody ServiceRequestDTO serviceRequestDTO){
        return new ResponseEntity<>(service.createService(serviceRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/service/")
    public List<ServiceResponseDTO> getAll(){
        return service.getAll();
    }
    @GetMapping("/service/{id}")
    public ResponseEntity<ServiceResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceResponseDTO> update(@PathVariable Long id, @RequestBody ServiceRequestDTO serviceRequestDTO){
        return new ResponseEntity<>(service.updateById(id,serviceRequestDTO),HttpStatus.OK);
    }
   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }*/
}
