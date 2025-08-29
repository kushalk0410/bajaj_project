package com.example.sqlsolver.model;

import lombok.Data;

// The response we get back (webhook + token)
@Data
public class GenerateResponse {
    private String webhook;
    private String accessToken;
}
