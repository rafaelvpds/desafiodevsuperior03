package com.devsuperior.desafio03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.desafio03.dto.request.RequestClientDto;
import com.devsuperior.desafio03.dto.response.ResponseClientDto;
import com.devsuperior.desafio03.entities.Client;
import com.devsuperior.desafio03.repositorie.ClientRepository;
import com.devsuperior.desafio03.service.exceptions.ResourceNotFoundExceptions;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ResponseClientDto findById(Long id) {

        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Id not found"));

        return new ResponseClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ResponseClientDto> findAll(Pageable pageable) {
        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());

        Page<Client> clientListPage = repository.findAll(pageable);

        return clientListPage.map(x -> new ResponseClientDto(x));
    }

    @Transactional
    public ResponseClientDto insert(RequestClientDto dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);

        return new ResponseClientDto(entity);
    }

    @Transactional
    public ResponseClientDto update(Long id, RequestClientDto dto) {
        Client entityClient = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("id not found"));
        copyDtoToEntity(dto, entityClient);

        entityClient = repository.save(entityClient);

        return new ResponseClientDto(entityClient);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundExceptions("id not found");
        }
    }

    private void copyDtoToEntity(RequestClientDto dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
