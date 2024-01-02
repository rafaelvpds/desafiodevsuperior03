package com.devsuperior.desafio03.dto.request;

import java.time.LocalDateTime;

public class RequestClientDto {
    private String name;
    private String cpf;
    private Double income;
    private LocalDateTime birthDate;
    private Integer children;

    public RequestClientDto(String name, String cpf, Double income, LocalDateTime birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

}
