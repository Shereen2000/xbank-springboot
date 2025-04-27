package com.tumiso.xbank.repositories;

import com.tumiso.xbank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientProfileRepository extends JpaRepository<Client,Integer> {

}
