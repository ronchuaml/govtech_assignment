package com.demo.assignment.service;

import com.demo.assignment.entity.Applicant;
import com.demo.assignment.entity.Application;
import com.demo.assignment.entity.Scheme;
import com.demo.assignment.repository.ApplicantRepository;
import com.demo.assignment.repository.ApplicationRepository;
import com.demo.assignment.repository.SchemeRepository;
import com.demo.assignment.requestDTO.ApplicationRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;
    private final SchemeRepository schemeRepository;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository, SchemeRepository schemeRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
        this.schemeRepository = schemeRepository;
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Transactional
    public Application createApplication(ApplicationRequest request) {
        Applicant applicant = applicantRepository.findById(request.getApplicantId())
                .orElseThrow(() -> new IllegalArgumentException("Applicant not found"));

        Scheme scheme = schemeRepository.findById(request.getSchemeId())
                .orElseThrow(() -> new IllegalArgumentException("Scheme not found"));

        Application application = new Application();
        application.setApplicant(applicant);
        application.setScheme(scheme);
        application.setStatus(request.getStatus());

        return applicationRepository.save(application);
    }
}