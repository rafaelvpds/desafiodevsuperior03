package com.devsuperior.desafio03.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio03.dto.response.ResponseClientDto;
import com.devsuperior.desafio03.entities.Client;
import com.devsuperior.desafio03.repositorie.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ResponseClientDto findById(Long id) {

        Optional<Client> client = repository.findById(id);
        Client opClient = client.get();
        return new ResponseClientDto(opClient);
    }

    @Transactional(readOnly = true)
    public Page<ResponseClientDto> findAll(Pageable pageable) {
        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        Page<Client> clientListPage = repository.findAll(pageable);

        return clientListPage.map(x -> new ResponseClientDto(x));
    }

}
