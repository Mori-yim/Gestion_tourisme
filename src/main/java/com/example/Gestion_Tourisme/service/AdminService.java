package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.entity.Admin;

import java.util.List;

public interface AdminService {
    public AdminResponseDTO create(AdminRequestDTO admin);
    public AdminResponseDTO getById(Long id);
    public List<AdminResponseDTO> getAll();
    public AdminResponseDTO UpdateById(Long id, AdminRequestDTO admin);
    public void delete(Long id);
}
