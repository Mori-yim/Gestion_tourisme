package com.example.Gestion_Tourisme.config;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    // PasswordEncoder bean - BCrypt haute sécurité (recommandé)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager - utilisé par le controller pour l'authentification
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // chaîne de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // on désactive les sessions => stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // endpoints publics pour s'enregistrer / login /Swagger
                        .requestMatchers("/api/auth/**","/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        // accès lecture services pour tous authentifiés et non-authentifiés (si voulu) :
                        .requestMatchers("/api/services").permitAll()
                        // endpoints réservés aux admins
                        .requestMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")/*hasRole("ADMIN")/
                        .requestMatchers("/api/agent/**").hasAuthority("ROLE_AGENT")
                        .requestMatchers("/api/client/**").hasAuthority("ROLE_CLIENT")
                        //.requestMatchers("/api/service/**").permitAll()
                        // endpoints admin pour creation/modification/suppression des services
                        // on protège via @PreAuthorize dans controller aussi
                        .anyRequest().authenticated()
                );

        // ajouter le filtre JWT avant UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}*/
