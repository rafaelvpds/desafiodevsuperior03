package com.devsuperior.desafio03.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class RequestClientDto {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 11, max = 11, message = "O campo CPF contem 11 digitos")
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Não pode ser conter data futuras")
    private LocalDate birthDate;
    private Integer children;

    public RequestClientDto(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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
