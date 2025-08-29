package com.example.sqlsolver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// The request we send to "generateWebhook"
@Data @NoArgsConstructor @AllArgsConstructor
public class GenerateRequest {
    private String name;
    private String regNo;
    private String email;
}
