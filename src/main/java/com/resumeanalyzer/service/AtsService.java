package com.resumeanalyzer.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AtsService {

    public int calculateScore(
            List<String> resumeSkills,
            List<String> jdSkills) {

        if(jdSkills.isEmpty()) {
            return 0;
        }

        int matched = 0;

        for(String skill : jdSkills) {

            if(resumeSkills.contains(skill)) {
                matched++;
            }
        }

        return (matched * 100) / jdSkills.size();
    }
}