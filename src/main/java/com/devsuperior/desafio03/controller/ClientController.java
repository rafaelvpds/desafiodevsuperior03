package com.devsuperior.desafio03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.desafio03.dto.request.RequestClientDto;
import com.devsuperior.desafio03.dto.response.ResponseClientDto;
import com.devsuperior.desafio03.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/{id}")
    public ResponseClientDto findById(@PathVariable Long id) {

        return service.findById(id);

    }

    @GetMapping
    public Page<ResponseClientDto> findAll(
            @PageableDefault(page = 0, size = 6) @SortDefault.SortDefaults({
                    @SortDefault(sort = "name", direction = Sort.Direction.DESC)
            }) Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ResponseClientDto insert(@RequestBody RequestClientDto dto) {
        return service.insert(dto);
    }
}
