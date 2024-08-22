package com.demo.assignment.repository;

import com.demo.assignment.entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchemeRepository extends JpaRepository<Scheme, String> {
}