package com.demo.assignment.service;

import com.demo.assignment.entity.Applicant;
import com.demo.assignment.entity.Household;
import com.demo.assignment.entity.Scheme;
import com.demo.assignment.entity.SchemeCriteria;
import com.demo.assignment.enums.EmploymentStatus;
import com.demo.assignment.enums.MaritalStatus;
import com.demo.assignment.repository.ApplicantRepository;
import com.demo.assignment.repository.SchemeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchemeCriteriaService {

    private final SchemeRepository schemeRepository;
    private final ApplicantRepository applicantRepository;

    public SchemeCriteriaService(SchemeRepository schemeRepository, ApplicantRepository applicantRepository) {
        this.schemeRepository = schemeRepository;
        this.applicantRepository = applicantRepository;
    }

    public List<Scheme> getEligibleSchemes(String applicantId) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        MaritalStatus maritalStatus = applicant.getMaritalStatus();
        EmploymentStatus employmentStatus = applicant.getEmploymentStatus();

        // Fetch all schemes
        List<Scheme> allSchemes = schemeRepository.findAll();
        List<Scheme> eligibleSchemes = new ArrayList<>();

        for (Scheme scheme : allSchemes) {
            boolean isEligible = false;

            for (SchemeCriteria criteria : scheme.getSchemeCriteria()) {
                if (isEligibleForScheme(criteria, maritalStatus, employmentStatus, applicant.getHousehold())) {
                    isEligible = true;
                    break;
                }
            }

            if (isEligible) {
                eligibleSchemes.add(scheme);
            }
        }

        return eligibleSchemes;
    }

    private boolean isEligibleForScheme(SchemeCriteria criteria, MaritalStatus maritalStatus, EmploymentStatus employmentStatus, List<Household> household) {
        boolean maritalStatusMatches = (criteria.getMaritalStatus() == null || criteria.getMaritalStatus().equals(maritalStatus));
        boolean employmentStatusMatches = (criteria.getEmploymentStatus() == null || criteria.getEmploymentStatus().equals(employmentStatus));


        boolean ageMatches = true;

        if (criteria.getHasChildren() != null && criteria.getHasChildren()) {
            ageMatches = false;

            for (Household member : household) {
                LocalDate dateOfBirth = member.getDateOfBirth();

                    int age = calculateAge(dateOfBirth);

                    if ((criteria.getChildrenMinAge() == null || age >= criteria.getChildrenMinAge()) &&
                            (criteria.getChildrenMaxAge() == null || age <= criteria.getChildrenMaxAge())) {
                        ageMatches = true;
                        break; // no need to check further if one child matches the condition
                    }
            }
        }

        return maritalStatusMatches && employmentStatusMatches && ageMatches;
    }

    private int calculateAge(LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            LocalDate today = LocalDate.now();
            return today.getYear() - dateOfBirth.getYear();
        }
        return 0;
    }
}
