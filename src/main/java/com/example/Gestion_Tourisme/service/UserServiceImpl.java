package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.Reservation;
import com.example.Gestion_Tourisme.entity.SiteTouristique;
import com.example.Gestion_Tourisme.entity.User;
import com.example.Gestion_Tourisme.repository.ReservationRepository;
import com.example.Gestion_Tourisme.repository.ServiceRepository;
import com.example.Gestion_Tourisme.repository.SiteTouristiqueRepository;
import com.example.Gestion_Tourisme.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private SiteTouristiqueRepository siteTouristiqueRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserResponseDTO create(UserRequestDTO user) {
        User user1 = modelMapper.map(user,User.class);
        User saveUser1 = userRepository.save(user1);
        return modelMapper.map(saveUser1,UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getById(Long id) {
       User user= userRepository.findById(id).get();
       return modelMapper.map(user,UserResponseDTO.class);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        //List<User> users= userRepository.findAll();
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateById(Long id, UserRequestDTO user) {
        UserResponseDTO user2= getById(id);
        User user1=modelMapper.map(user2,User.class);
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setTelephone(user.getTelephone());
        user1.setDateInscription(user.getDateInscription());
        User updateUser = userRepository.save(user1);

        return modelMapper.map(updateUser,UserResponseDTO.class);
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);

    }

    @Override
    public UserResponseDTO getUserByusername(String name) {
        return modelMapper.map(userRepository.findUserByUsername(name),UserResponseDTO.class);
    }

    @Override
    public void assignerServiceUser(Long user_id, Long service_id) {
        User user = userRepository.findById(user_id).get();
        com.example.Gestion_Tourisme.entity.Service service = serviceRepository.findById(service_id).get();
        user.getServices().add(service);
        service.getUsers().add(user);
        userRepository.save(user);
    }

    @Override
    public void assignerReservationUser(Long user_id, Long reservation_id) {
        User user = userRepository.findById(user_id).get();
        Reservation reservation = reservationRepository.findById(reservation_id).get();
        user.getReservations().add(reservation);
        reservation.getUsers().add(user);
        userRepository.save(user);
    }

    @Override
    public void assignerSiteUser(Long user_id, Long site_id) {
        User user = userRepository.findById(user_id).get();
        SiteTouristique site = siteTouristiqueRepository.findById(site_id).get();
        user.getSiteTouristiques().add(site);
        site.getUsers().add(user);
        userRepository.save(user);
    }

    @Override
    public List<User> getUserService() {
        return userRepository.findUsersService();
    }

    @Override
    public List<User> getUserNotService() {
        return userRepository.findUsersNotService();
    }


}
