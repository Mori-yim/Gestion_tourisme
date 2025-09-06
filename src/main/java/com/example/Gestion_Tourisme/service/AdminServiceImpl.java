package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.adminDto.AdminRequestDTO;
import com.example.Gestion_Tourisme.dto.adminDto.AdminResponseDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.Admin;
import com.example.Gestion_Tourisme.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminResponseDTO create(AdminRequestDTO admin) {
        Admin admin1 = modelMapper.map(admin,Admin.class);
        Admin saveAdmin= adminRepository.save(admin1);
        return modelMapper.map(saveAdmin,AdminResponseDTO.class);
    }

    @Override
    public AdminResponseDTO getById(Long id) {
        Admin admin = adminRepository.findById(id).get();
        return modelMapper.map(admin,AdminResponseDTO.class);
    }

    @Override
    public List<AdminResponseDTO> getAll() {
        //List<Admin> admins = adminRepository.findAll();
        return  adminRepository.findAll().stream()
                .map(admin -> modelMapper.map(admin, AdminResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminResponseDTO UpdateById(Long id, AdminRequestDTO admin) {
           AdminResponseDTO admin1 = getById(id);
            Admin existAdmin = modelMapper.map(admin1,Admin.class);
            existAdmin.setName(admin.getName());
            existAdmin.setUsername(admin.getUsername());
            existAdmin.setEmail(admin.getEmail());
            existAdmin.setPassword(admin.getPassword());
            existAdmin.setTelephone(admin.getTelephone());
            Admin saveadmin = adminRepository.save(existAdmin);
          return modelMapper.map(saveadmin,AdminResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
