package com.devsuperior.desafio03.dto.response;

import java.time.LocalDate;

import com.devsuperior.desafio03.dto.request.RequestClientDto;
import com.devsuperior.desafio03.entities.Client;

public class ResponseClientDto {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ResponseClientDto() {
    }

    public ResponseClientDto(String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ResponseClientDto(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public ResponseClientDto(RequestClientDto request) {
        id = request.getId();
        name = request.getName();
        cpf = request.getCpf();
        income = request.getIncome();
        birthDate = request.getBirthDate();
        children = request.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

}
