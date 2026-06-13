package com.resumeanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resumeanalyzer.model.ResumeAnalysis;

public interface ResumeRepository
        extends JpaRepository<ResumeAnalysis, Long> {

}