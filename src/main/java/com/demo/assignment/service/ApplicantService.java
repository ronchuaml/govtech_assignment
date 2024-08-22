package com.demo.assignment.service;

import com.demo.assignment.entity.Applicant;
import com.demo.assignment.entity.Scheme;
import com.demo.assignment.repository.ApplicantRepository;
import com.demo.assignment.repository.SchemeRepository;
import com.demo.assignment.requestDTO.ApplicantRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final SchemeRepository schemeRepository;

    public ApplicantService(ApplicantRepository applicantRepository, SchemeRepository schemeRepository) {
        this.applicantRepository = applicantRepository;
        this.schemeRepository = schemeRepository;
    }

    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = applicantRepository.findAll();
        return applicants;
    }

    public Applicant createApplicant(ApplicantRequest applicantRequest) {
        Applicant applicant = new Applicant();
        applicant.setName(applicantRequest.getName());
        applicant.setMaritalStatus(applicantRequest.getMaritalStatus());
        applicant.setEmploymentStatus(applicantRequest.getEmploymentStatus());
        applicant.setSex(applicantRequest.getSex());
        applicant.setDateOfBirth(applicantRequest.getDateOfBirth());

        return applicantRepository.save(applicant);
    }

}