package com.example.sqlsolver.repo;

import com.example.sqlsolver.model.SolutionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

// Basic repo for storing solution locally
public interface SolutionRepo extends JpaRepository<SolutionRecord, Long> { }
