package com.devsuperior.desafio03.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.desafio03.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
