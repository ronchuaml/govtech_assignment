package com.demo.assignment.repository;

import com.demo.assignment.entity.SchemeCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchemeCriteriaRepository extends JpaRepository<SchemeCriteria, String> {
}

