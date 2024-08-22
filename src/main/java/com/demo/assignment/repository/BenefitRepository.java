package com.demo.assignment.repository;

import com.demo.assignment.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BenefitRepository extends JpaRepository<Benefit, String> {
}
