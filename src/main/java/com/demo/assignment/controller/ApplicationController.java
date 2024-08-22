package com.demo.assignment.controller;

import com.demo.assignment.entity.Application;
import com.demo.assignment.requestDTO.ApplicationRequest;
import com.demo.assignment.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationRequest application) {
        return new ResponseEntity<>(applicationService.createApplication(application), HttpStatus.CREATED);
    }
}