package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.User;
import com.example.Gestion_Tourisme.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.create(userRequestDTO),HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<UserResponseDTO> getAll(){
        return userService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
