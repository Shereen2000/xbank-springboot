package com.tumiso.xbank.auth.repositories;

import com.tumiso.xbank.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository  extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String username);

}
