package com.devsuperior.desafio03.dto.exception;

import java.time.Instant;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String patch;

    public CustomError(Instant timestamp, Integer status, String error, String patch) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.patch = patch;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPatch() {
        return patch;
    }

}
