package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.User;

import java.util.List;

public interface UserService {
    public UserResponseDTO create(UserRequestDTO user);
    public UserResponseDTO getById(Long id);
    public List<UserResponseDTO> getAll();
    public UserResponseDTO updateById(Long id, UserRequestDTO user);
    public void delete(Long id);
    public UserResponseDTO getUserByusername(String name);
    public void assignerServiceUser(Long user_id, Long service_id);
    public void assignerReservationUser(Long user_id, Long reservation_id);
    public void assignerSiteUser(Long user_id, Long site_id);
    public List<User> getUserService();
    public List<User> getUserNotService();
}
