package com.resumeanalyzer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private static final List<String> SKILLS =
            Arrays.asList(
                    "java",
                    "spring boot",
                    "mysql",
                    "html",
                    "css",
                    "javascript",
                    "react",
                    "aws",
                    "docker",
                    "mongodb"
            );

    public List<String> detectSkills(String text) {

        text = text.toLowerCase();

        List<String> found =
                new ArrayList<>();

        for(String skill : SKILLS) {

            if(text.contains(skill)) {
                found.add(skill);
            }
        }

        return found;
    }
}