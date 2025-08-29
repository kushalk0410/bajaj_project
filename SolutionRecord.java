package com.example.sqlsolver.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

// Entity to save what we sent
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SolutionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regNo;
    private String questionType; // ODD or EVEN
    @Column(length = 4000)
    private String finalQuery;

    private String webhookUrl;
    private String accessToken;

    private OffsetDateTime createdAt;
    private Integer submitStatus;
    @Column(length = 2000)
    private String submitResponse;
}
