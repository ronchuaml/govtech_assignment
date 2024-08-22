package com.demo.assignment.repository;

import com.demo.assignment.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicantRepository extends JpaRepository<Applicant, String> {
}
