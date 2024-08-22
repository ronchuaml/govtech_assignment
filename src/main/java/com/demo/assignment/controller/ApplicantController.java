package com.demo.assignment.controller;

import com.demo.assignment.entity.Applicant;
import com.demo.assignment.requestDTO.ApplicantRequest;
import com.demo.assignment.service.ApplicantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    @PostMapping
    public ResponseEntity<Applicant> createApplicant(@Valid @RequestBody ApplicantRequest applicantRequest) {
        Applicant createdApplicant = applicantService.createApplicant(applicantRequest);
        return new ResponseEntity<>(createdApplicant, HttpStatus.CREATED);
    }
}