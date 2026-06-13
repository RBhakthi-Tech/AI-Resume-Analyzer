package com.resumeanalyzer.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.resumeanalyzer.dto.AnalysisResponse;
import com.resumeanalyzer.service.AtsService;
import com.resumeanalyzer.service.PdfService;
import com.resumeanalyzer.service.SkillService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private AtsService atsService;

    @PostMapping("/analyze")
    public AnalysisResponse analyze(
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("jobDescription") String jobDescription)
            throws Exception {

    	File tempFile = File.createTempFile("resume_", ".pdf");

    	resume.transferTo(tempFile);

    	String resumeText = pdfService.extractText(tempFile);

        List<String> resumeSkills =
                skillService.detectSkills(resumeText);

        List<String> jdSkills =
                skillService.detectSkills(jobDescription);

        int score =
                atsService.calculateScore(
                        resumeSkills,
                        jdSkills);

        List<String> missing =
                new ArrayList<>(jdSkills);

        missing.removeAll(resumeSkills);

        return new AnalysisResponse(
                score,
                resumeSkills,
                missing);
    }
}