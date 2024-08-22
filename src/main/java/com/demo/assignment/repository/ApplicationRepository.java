package com.demo.assignment.repository;

import com.demo.assignment.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, String> {
}
