package com.demo.assignment.controller;

import com.demo.assignment.entity.Scheme;
import com.demo.assignment.service.SchemeCriteriaService;
import com.demo.assignment.service.SchemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    private final SchemeService schemeService;
    private final SchemeCriteriaService schemeCriteriaService;

    public SchemeController(SchemeService schemeService, SchemeCriteriaService schemeCriteriaService) {
        this.schemeService = schemeService;
        this.schemeCriteriaService = schemeCriteriaService;
    }

    @GetMapping
    public ResponseEntity<List<Scheme>> getAllSchemes() {
        return ResponseEntity.ok(schemeService.getAllSchemes());
    }

    @GetMapping("/eligible")
    public ResponseEntity<List<Scheme>> getEligibleSchemes(@RequestParam String applicantId) {
        List<Scheme> eligibleSchemes = schemeCriteriaService.getEligibleSchemes(applicantId);
        return ResponseEntity.ok(eligibleSchemes);
    }
}