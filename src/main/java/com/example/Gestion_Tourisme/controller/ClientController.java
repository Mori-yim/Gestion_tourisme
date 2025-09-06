package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.clientDto.ClientRequestDto;
import com.example.Gestion_Tourisme.dto.clientDto.ClientResponseDto;
import com.example.Gestion_Tourisme.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<ClientResponseDto> create(@RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(clientService.create(clientRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<ClientResponseDto> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(clientService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Long id, @RequestBody ClientRequestDto clientRequestDto){
        return new ResponseEntity<>(clientService.UpdateById(id,clientRequestDto),HttpStatus.OK);
    }

}
