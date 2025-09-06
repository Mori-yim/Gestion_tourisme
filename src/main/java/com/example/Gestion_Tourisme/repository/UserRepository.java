package com.example.Gestion_Tourisme.repository;

import com.example.Gestion_Tourisme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    //obtenir un utilisateur par son username
    public User findUserByUsername(String username);
    //obtenir les user ayant le/les services
    @Query("SELECT u FROM User u WHERE u.services IS NOT EMPTY ")
    List<User> findUsersService();
    //afficher les user n'ayant aucun service
    @Query("SELECT u FROM User u WHERE u.services IS EMPTY")
    List<User> findUsersNotService();

}
