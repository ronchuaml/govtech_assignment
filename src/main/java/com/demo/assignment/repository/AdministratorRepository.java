package com.demo.assignment.repository;

import com.demo.assignment.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
}

