package com.example.Gestion_Tourisme.service;

import com.example.Gestion_Tourisme.entity.*;
import com.example.Gestion_Tourisme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.Gestion_Tourisme.entity.User u = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // accord d'un seul rôle (SimpleGrantedAuthority attend le préfixe ROLE_ en général)
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(u.getRole().name());

        // retourne l'objet UserDetails utilisé par Spring Security
        return new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                Collections.singleton(authority)
        );
    }

}

