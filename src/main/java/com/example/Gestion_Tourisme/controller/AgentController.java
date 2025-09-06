package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.agentDto.AgentRequestDTO;
import com.example.Gestion_Tourisme.dto.agentDto.AgentResponseDTO;
import com.example.Gestion_Tourisme.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/create")
    public ResponseEntity<AgentResponseDTO> create(@RequestBody AgentRequestDTO agentRequestDTO){
        return new ResponseEntity<>(agentService.create(agentRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<AgentResponseDTO> getAll(){
        return agentService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgentResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(agentService.getById(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AgentResponseDTO> update(@PathVariable Long id, @RequestBody AgentRequestDTO agentRequestDTO){
        return new ResponseEntity<>(agentService.UpdateById(id,agentRequestDTO),HttpStatus.OK);
    }

}
