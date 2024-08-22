package com.demo.assignment.requestDTO;

import com.demo.assignment.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ApplicationRequest {

    @NotBlank(message = "Applicant ID is required")
    private String applicantId;

    @NotBlank(message = "Scheme ID is required")
    private String schemeId;

    @NotNull(message = "Application status is required")
    private ApplicationStatus status;

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}