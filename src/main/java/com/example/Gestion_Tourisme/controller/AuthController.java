package com.example.Gestion_Tourisme.controller;

import com.example.Gestion_Tourisme.dto.UserRest;
import com.example.Gestion_Tourisme.dto.userDto.UserRequestDTO;
import com.example.Gestion_Tourisme.dto.userDto.UserResponseDTO;
import com.example.Gestion_Tourisme.entity.User;
import com.example.Gestion_Tourisme.repository.UserRepository;
import com.example.Gestion_Tourisme.service.CustomerUserDetailsService;
import com.example.Gestion_Tourisme.service.UserService;
import com.example.Gestion_Tourisme.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    /**
     * Inscription : on reçoit un UserRequestDto.
     * On crée un Client ou Admin selon role.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRequestDTO dto) {
        try {
            UserResponseDTO created = userService.registerUser(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Connexion : on reçoit username et password (dans un UserRequestDto ou un DTO spécifique).
     * On authentifie via AuthenticationManager et on renvoie un token JWT.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRest loginDto) {
        try {
            // on authentifie : Spring vérifie username & password via userDetailsService + encoder
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );

            // si authentifié, on crée un token
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getUsername());
            String token = jwtUtil.generateToken(userDetails);

            // retourner token et quelques infos utiles
            return ResponseEntity.ok().body(Map.of("token", token, "username", userDetails.getUsername()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // La déconnexion est gérée côté client en supprimant le token.
        // Le backend est stateless et ne garde pas de sessions utilisateur.
        return ResponseEntity.ok("Déconnexion réussie !");
    }
    // changement de mot de passe: endpoint protégé
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestParam String username,
                                            @RequestParam String email,
                                            @RequestParam String newPassword) {
        User user = userRepository.findByUsername(username).orElseThrow();
        // vérifier password actuel
        /*if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Mot de passe actuel invalide");
        }*/
        if(user.getEmail().equals(email)) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return ResponseEntity.ok("Mot de passe changé avec succès ✅");
        }
        return ResponseEntity.ok("nomd'utilisateur ou email incorrecte");
    }

}
