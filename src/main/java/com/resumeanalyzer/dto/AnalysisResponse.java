package com.resumeanalyzer.dto;

import java.util.List;

public class AnalysisResponse {

    private int score;

    private List<String> skills;

    private List<String> missing;

    public AnalysisResponse() {
    }

    public AnalysisResponse(
            int score,
            List<String> skills,
            List<String> missing) {

        this.score = score;
        this.skills = skills;
        this.missing = missing;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getMissing() {
        return missing;
    }

    public void setMissing(List<String> missing) {
        this.missing = missing;
    }
}